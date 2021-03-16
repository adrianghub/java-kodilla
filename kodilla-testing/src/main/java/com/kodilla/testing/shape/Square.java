package com.kodilla.testing.shape;

public class Square extends AbstractShape implements Shape{
    private final int aField;

    public Square(String name, int aField) {
        super(name);
        this.aField = aField;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return aField * aField;
    }
}
