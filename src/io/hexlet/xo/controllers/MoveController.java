package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exeptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exeptions.InvalidPointExeption;

import java.awt.*;

/**
 * Created by admin on 20.01.2016.
 */
public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointExeption,
                                                        AlreadyOccupiedException {
        if(field.getFigure(point) != null){
            throw  new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);


    }
}
