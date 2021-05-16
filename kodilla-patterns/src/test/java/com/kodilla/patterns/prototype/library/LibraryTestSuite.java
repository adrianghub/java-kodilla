package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Book book1 = new Book("Kwiatki", "Marysia", LocalDate.of(2021, 5, 11));
        Book book2 = new Book("Kwiatki i bratki", "Marysia", LocalDate.of(2019, 11, 24));
        Book book3 = new Book("Wiatr", "Marysia", LocalDate.of(2011, 7, 1));

        Library nationalLibrary = new Library("Biblioteka Narodowa");
        nationalLibrary.getBooks().add(book1);
        nationalLibrary.getBooks().add(book2);
        nationalLibrary.getBooks().add(book3);

        //When

        Library clonedLibrary = null;
        try {
            clonedLibrary = nationalLibrary.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = nationalLibrary.deepCopy();
            deepClonedLibrary.setName("Deeped Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        nationalLibrary.getBooks().remove(book1);


        //Then
        System.out.println(nationalLibrary);
        assert clonedLibrary != null;
        System.out.println(clonedLibrary);
        assert deepClonedLibrary != null;
        System.out.println(deepClonedLibrary);
        assertEquals(2, nationalLibrary.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), nationalLibrary.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), nationalLibrary.getBooks());
    }
}
