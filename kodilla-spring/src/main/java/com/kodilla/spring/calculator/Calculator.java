package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    private Display display;

    public Calculator(final Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        double res = a + b;
        display.displayValue(res);
        return res;
    }

    public double sub(double a, double b) {
        double res = a - b;
        display.displayValue(res);
        return res;
    }

    public double mul(double a, double b) {
        double res = a * b;
        display.displayValue(res);
        return res;
    }

    public double div(double a, double b) {
        double res = a / b;
        display.displayValue(res);
        return res;
    }
}
