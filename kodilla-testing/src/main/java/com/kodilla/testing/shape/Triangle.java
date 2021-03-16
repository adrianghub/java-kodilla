package com.kodilla.testing.shape;

public class Triangle extends AbstractShape implements Shape {
    private final int aField;
    private final int height;
    private int radius;

    public Triangle(String name, int aField, int height) {
        super(name);
        this.aField = aField;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return 0.5 * aField * height;
    }
}
