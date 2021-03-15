package com.kodilla.testing.shape;

public class Square extends AbstractShape implements Shape{
    private final int aField;

    public Square(String name, String field, int aField) {
        super(name, field);
        this.aField = aField;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return aField * aField;
    }
}
