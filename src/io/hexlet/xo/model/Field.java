package io.hexlet.xo.model;


import io.hexlet.xo.model.exeptions.InvalidPointExeption;

import java.awt.*;

/**
 * Created by admin on 14.08.2015.
 */
public class Field {


    public static final int MIN_COORDINATE = 0;


    private final Figure[][] field;

    private final int fieldSize;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize(){
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointExeption {
        if(!checkPoint(point)){
            throw new InvalidPointExeption();
        }
        return field[point.x] [point.y];
    }

    public void setFigure(final Point point, final Figure figure)throws InvalidPointExeption{
        if(!checkPoint(point)){
            throw new InvalidPointExeption();
        }
        field[point.x] [point.y] = figure;

    }

    private boolean checkPoint(final Point point){
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);

    }
    private boolean checkCoordinate(final  int coordinate, final int maxCoordinate){
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
