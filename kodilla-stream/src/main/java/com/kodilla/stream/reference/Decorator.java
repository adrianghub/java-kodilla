package com.kodilla.stream.reference;

import java.util.Locale;

public class Decorator {

    public static String decorateToUppercase(String sentence) {
        return sentence.toUpperCase();
    }

    public static String decorateWithAmpersand(String sentence) {
        return "&&&" + sentence + "&&&";
    }

    public static String decorateWithThreeDots(String sentence) {
        return sentence + "...";
    }

    public static String decorateWithSmileEmoji(String sentence) {
        return sentence + " :D";
    }
}
