package com.kodilla.stream.array;

import java.util.stream.IntStream;

public class Operations implements ArrayOperations {

    @Override
    public double getAverage(int[] numbers) {

        IntStream.of(numbers).forEach(System.out::println);

        return IntStream.of(numbers)
                .average().getAsDouble();
    }
}
