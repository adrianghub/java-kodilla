package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = {1, 2, 3, 4};
        ArrayOperations operations = new Operations();
        //When
        double averageValue = operations.getAverage(numbers);

        //Then
        assertEquals(2.5, averageValue);
    }

}
