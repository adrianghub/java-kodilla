package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();


        if (collection.size() > 12) {
            String movie = collection.get(0);
            System.out.println(movie);

            String secondMovie = collection.get(12);
            System.out.println(secondMovie);
        }
    }
}
