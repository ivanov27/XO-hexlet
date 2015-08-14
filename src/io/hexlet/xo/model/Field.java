package io.hexlet.xo.model;


import io.hexlet.xo.model.exeptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exeptions.InvalidPointExeption;

import java.awt.*;

/**
 * Created by admin on 14.08.2015.
 */
public class Field {

    public static final int FIELD_SIZE = 3;
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = FIELD_SIZE;
    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];
    public int getSize(){
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointExeption {
        if(!checkPoint(point)){
            throw new InvalidPointExeption();
        }
        return field[point.x] [point.y];
    }

    public void setFigure(final Point point, final Figure figure)throws InvalidPointExeption, AlreadyOccupiedException{
        if(!checkPoint(point)){
            throw new InvalidPointExeption();
        }
        if(field[point.x] [point.y] != null){
            throw  new AlreadyOccupiedException();
        }
        field[point.x] [point.y] = figure;

    }

    private boolean checkPoint(final Point point){
        return checkCoordinate(point.x) && checkCoordinate(point.y);

    }
    private boolean checkCoordinate(final  int coordinate){
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
