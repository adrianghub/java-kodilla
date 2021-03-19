package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.reference.Decorator;

public class StreamMain {
    public static void main(String[] args) {
//        Processor processor = new Processor();
//        processor.execute(() -> System.out.println("This is an example text from lambda expression."));
//
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//
//        System.out.println("Expression with lambdas: ");
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
//
//        System.out.println("Expression with method reference: ");
//        expressionExecutor.executeExpression(2, 2, FunctionalCalculator::multiplyAByB);

//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//
//        poemBeautifier.beautify("LMAO", Decorator::decorateWithSmileEmoji);
//        poemBeautifier.beautify("was ist eine gute programmiersprache", Decorator::decorateToUppercase);
//        poemBeautifier.beautify("Litwo, Ojczyzno moja", sentence -> sentence + "...");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }

}
