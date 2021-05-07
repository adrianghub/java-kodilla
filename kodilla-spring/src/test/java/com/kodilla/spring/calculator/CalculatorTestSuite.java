package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Display display;

    @Test
    void testCalculations() {
        //Given
        Calculator calc = new Calculator(display);

        //When
        double res1 = calc.add(2, 2);
        double res2 = calc.sub(2, 2);
        double res3 = calc.mul(2, 2);
        double res4 = calc.div(2, 2);

        //Then
        assertEquals(4, res1);
        assertEquals(0, res2);
        assertEquals(4, res3);
        assertEquals(1, res4);

    }

}
