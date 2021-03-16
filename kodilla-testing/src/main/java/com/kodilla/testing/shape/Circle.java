package com.kodilla.testing.shape;

public class Circle extends AbstractShape implements Shape{
    private int radius;

    public Circle(String name, int radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }
}
