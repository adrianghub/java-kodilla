package com.kodilla.testing.shape;

public class Circle extends AbstractShape implements Shape{
    private int radius;

    public Circle(String name, String field, int radius) {
        super(name, field);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }
}
