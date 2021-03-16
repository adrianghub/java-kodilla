package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector implements Shape {

    private List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape theShape) {
        figures.add(theShape);
    }

    public boolean removeFigure(Shape theShape) {
        boolean result = false;
        if (figures.contains(theShape)) {
            figures.remove(theShape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int figureNumber) {
        if (figureNumber >= 0 && figureNumber < figures.size()) {
            return figures.get(figureNumber);
        }
        return null;
    }

    public int getFiguresQuantity() {
        return figures.size();
    }

    public List<String> showFigures() {
        List<String> figureNames = new ArrayList<>();

        for (Shape figure: figures) {
            figureNames.add(figure.getShapeName());
        }
        return figureNames;
    }

    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public double getField() {
        return 0;
    }
}
