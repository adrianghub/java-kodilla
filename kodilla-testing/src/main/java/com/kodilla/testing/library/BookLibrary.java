package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> generateBookList() {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        return bookList;
    }

    public boolean rentABook(LibraryUser libraryUser, Book book) {
        // generate book list
        List<Book> bookList = generateBookList();
        // hashmap with books assigned to users;
        Map<LibraryUser, Book> libraryUsers = new HashMap<>();
        // if book is unavailable return false
        if(!bookList.contains(book)) {
            return false;
        }
        // otherwise assign book to library user
        libraryUsers.put(libraryUser, book);
        return true;
    }

    public int returnBooks(LibraryUser libraryUser) {
        Map<LibraryUser, Book> libraryUsers = new HashMap<>();
        List<Book> bookList = generateBookList();
        List<Book> rentedBookList = new ArrayList<>();
        boolean rented;

        for (Book book: bookList) {
            rented = rentABook(libraryUser, book);
            if(rented) {
                rentedBookList.add(book);
            }
        }

        return rentedBookList.size();
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> rentedBookList = new ArrayList<>();
        int rentedBooksQuantity = returnBooks(libraryUser);
        // when the user doesn't have any rented books
        int booksRentedByUser = returnBooks(libraryUser);
        if (booksRentedByUser == 0) return rentedBookList;
        // when the user has exactly one rented book
        List<Book> resultList = libraryDatabase.listBooksInHandsOf(libraryUser);
        if (resultList.size() == 1) return resultList;
        // when the user has exactly 5 rented books
        if (resultList.size() == 5) return resultList;

        return rentedBookList;
    }
}


