package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Sex;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forumHomogenizowane = new Forum();

        Map<Integer, ForumUser> resultOfNaturalSelection = forumHomogenizowane.getUserList().stream()
                .filter(user -> user.getSex().equals(Sex.M))
                .filter(user -> user.getYear() < 2003)
                .filter(user -> user.getNumberOfPublishedPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getUniqueID, user -> user));

        System.out.println("Reminded forum users: " + resultOfNaturalSelection.size());
        resultOfNaturalSelection.entrySet().stream()
                .map(entry -> "ID #" + entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }

}
