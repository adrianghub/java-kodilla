package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            SecondChallenge secondChallenge = new SecondChallenge();
            System.out.println(secondChallenge.probablyIWillThrowException(1 ,1));
        } catch(Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
