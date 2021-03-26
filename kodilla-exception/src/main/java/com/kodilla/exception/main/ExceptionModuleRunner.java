package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}
