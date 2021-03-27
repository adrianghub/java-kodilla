package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader();
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Exception caught: " + e);
        }

    }
}
