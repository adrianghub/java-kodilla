package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuite {

    public static final String CIRCLE_NAME = "The rounded circle";
    public static final String SQUARE_NAME = "The angular square";
    public static final String RECTANGLE_NAME = "The long rectangle";


    double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Test
    void testFactoryCircle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        assertEquals(calculateCircleArea(4.5), circle.getArea(), 0);
        assertEquals(CIRCLE_NAME, circle.getName());
    }

    @Test
    void testFactorySquare() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        assertEquals(28.0, square.getCircumference(), 0);
        assertEquals(SQUARE_NAME, square.getName());
    }

    @Test
    void testFactoryRectangle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        assertEquals(37.50, rectangle.getArea(), 0);
        assertEquals(RECTANGLE_NAME, rectangle.getName());
    }
}
