package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTestSuite {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When create oddNumberExterminator " +
            "then exterminate should return empty list on list without any numbers"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> emptyList = new ArrayList<>();

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        // When
        List<Integer> oddNumbers = oddNumbersExterminator.exterminate(emptyList);

        List<Integer> expectedResult = new ArrayList<>();

        Collections.sort(oddNumbers);
        Collections.sort(expectedResult);

        System.out.println("Testing if number list: " + oddNumbers + " matches numbers: " + expectedResult);

        // Then
        Assertions.assertEquals(expectedResult, oddNumbers);

    }

    @DisplayName("When create oddNumberExterminator " +
                    "then exterminate should return list of odd numbers on list filled with numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(5, 6, 15, 13, 22, 18, 7));

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        // When
        List<Integer> oddNumbers = oddNumbersExterminator.exterminate(numberList);

        List<Integer> expectedResult = Arrays.asList(5, 13, 15, 7);

        System.out.println("Testing if number list: " + oddNumbers + " matches numbers: " + expectedResult);

        Collections.sort(oddNumbers);
        Collections.sort(expectedResult);

        // Then
        Assertions.assertEquals(expectedResult, oddNumbers);
    }
}