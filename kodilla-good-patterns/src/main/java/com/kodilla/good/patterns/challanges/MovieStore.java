package com.kodilla.good.patterns.challanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieStore {

    public Map<String, List<String>> getMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Zelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> bookTitlesWithTranslations = new HashMap<>();
        bookTitlesWithTranslations.put("IM", ironManTranslations);
        bookTitlesWithTranslations.put("AV", avengersTranslations);
        bookTitlesWithTranslations.put("FL", flashTranslations);

        bookTitlesWithTranslations.forEach((key, value) -> System.out.print(String.join("!", value) + "!"));


        return bookTitlesWithTranslations;
    }
}