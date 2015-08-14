package io.hexlet.xo.model;


import java.awt.*;

/**
 * Created by admin on 14.08.2015.
 */
public class Field {

    public static final int FIELD_SIZE = 3;
    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];
    public int getSize(){
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point){
        return field[point.x] [point.y];
    }

    public void setFigure(final Point point, final Figure figure){
        field[point.x] [point.y] = figure;

    }

}
