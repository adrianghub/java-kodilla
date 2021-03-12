package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.user.SimpleUser;

import java.util.ArrayList;
import java.util.List;

public class TestingMain {
    public static void main(String[] args) {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            integerArrayList.add(i);
        }

        List<Integer> oddNumbers = oddNumbersExterminator.exterminate(integerArrayList);

        for (Integer num : oddNumbers) {
            System.out.print(num + " ");
        }
    }
}
