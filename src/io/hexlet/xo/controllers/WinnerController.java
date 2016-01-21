package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exeptions.InvalidPointExeption;

import java.awt.*;

/**
 * Created by admin on 21.01.2016.
 */
public class WinnerController {

    public Figure getWinner(final Field field){


        try {
            for(int i = 0; i < 3; i++)
            if(check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1 )))
                return field.getFigure(new Point(i, 0));

            for(int i = 0; i < 3; i++)
                if(check(field, new Point(i, 0), p -> new Point(p.x + 1, p.y )))
                    return field.getFigure(new Point(0, i));

            if(check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if(check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));

        } catch (InvalidPointExeption e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator ){

        final  Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (InvalidPointExeption e) {
            return true;
        }

        if(currentFigure == null) return false;

        if(currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private  interface  IPointGenerator{

        public Point next(final Point point);
    }
}
