package com.kodilla.testing.shape;

import java.util.Objects;

public class AbstractShape implements Shape {
    protected String name;

    public AbstractShape(String name) {
        this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractShape)) return false;
        AbstractShape that = (AbstractShape) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
