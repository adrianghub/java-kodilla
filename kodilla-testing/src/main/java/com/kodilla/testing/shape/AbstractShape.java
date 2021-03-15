package com.kodilla.testing.shape;

import java.util.Objects;

public class AbstractShape implements Shape {
    protected String name;
    protected String field;

    public AbstractShape(String name, String field) {
        this.name = name;
        this.field = field;
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
        return Objects.equals(name, that.name) && Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, field);
    }
}
