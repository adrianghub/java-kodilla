package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        // Test SimpleUser class
        SimpleUser user = new SimpleUser("jacek1231");

        String result = user.getUsername();

        if (result.equals("jacek1231")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Test Calculator class
        Calculator calculator = new Calculator();

        int sum = calculator.add(2, 2);
        int sum2 = calculator.add(8, 2);

        if (sum == 4) {
            System.out.println("Calculator add() method successfully passed test!");
        } else {
            System.out.println("Calculator add() method failed test!");
        }

        if (sum2 == 6) {
            System.out.println("Calculator add() method successfully passed test!");
        } else {
            System.out.println("Calculator add() method failed test!");
        }

        int subtraction = calculator.subtract(10, 5);
        int subtraction2 = calculator.subtract(10, 4);

        if (subtraction == 5) {
            System.out.println("Calculator subtract() method successfully passed test!");
        } else {
            System.out.println("Calculator subtract() method failed test!");
        }

        if (subtraction2 == 14) {
            System.out.println("Calculator subtract() method successfully passed test!");
        } else {
            System.out.println("Calculator subtract() method failed test!");
        }
    }
}
