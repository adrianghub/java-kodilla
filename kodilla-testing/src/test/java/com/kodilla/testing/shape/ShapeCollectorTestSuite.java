package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Test ShapeCollector")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test figures")
    public class testFigures {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle theCircle = new Circle("kolko", 2);
            //When
            shapeCollector.addFigure(theCircle);
            //Then
            assertEquals(1, shapeCollector.getFiguresQuantity());
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle theCircle = new Circle("kolko", 2);
            shapeCollector.addFigure(theCircle);
            //When
            boolean result = shapeCollector.removeFigure(theCircle);
            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getFiguresQuantity());
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle theCircle = new Circle("kolko", 2);
            shapeCollector.addFigure(theCircle);
            //When
            Shape retrievedFigure;
            retrievedFigure = shapeCollector.getFigure(0);
            //Then
            assertEquals(theCircle, retrievedFigure);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle theCircle = new Circle("kolko", 2);
            Square theSquare = new Square("kwadrat", 2);
            Triangle theTriangle = new Triangle("trojkat", 2, 4);
            shapeCollector.addFigure(theCircle);
            shapeCollector.addFigure(theSquare);
            shapeCollector.addFigure(theTriangle);
            //When
            List<String> allFigures = shapeCollector.showFigures();
            List<String> expectedResult = new ArrayList<>();
            expectedResult.add(theCircle.getShapeName());
            expectedResult.add(theSquare.getShapeName());
            expectedResult.add(theTriangle.getShapeName());
            //Then
            assertEquals(expectedResult, allFigures);
        }
    }

    @Nested
    @DisplayName("Test shape")
    public class testShape {
        @Test
        void testGetShapeName() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square theSquare = new Square("kwadrat", 2);
            //When
            String figureName = theSquare.getShapeName();
            //Then
            assertEquals("kwadrat", figureName);
        }

        @Test
        void testGetField() {
            //Given
            Circle theCircle = new Circle("kolko", 2);
            Square theSquare = new Square("kwadrat", 2);
            Triangle theTriangle = new Triangle("trojkat", 2, 4);
            //When
            double squareField = theSquare.getField();
            double expectedSquareField = 2 * 2;
            double triangleField = theTriangle.getField();
            double expectedTriangleField = 0.5 * 2 * 4;
            double circleField = theCircle.getField();
            double expectedCircleField = Math.PI * Math.pow(2, 2);
            //Then
            assertEquals(expectedSquareField, squareField);
            assertEquals(expectedTriangleField, triangleField);
            assertEquals(expectedCircleField, circleField);
        }
    }


}
