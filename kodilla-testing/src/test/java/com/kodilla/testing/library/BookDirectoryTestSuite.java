package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Nested
    @DisplayName("Test available books in library")
    public class testBooks {
        @Test
        void testListBooksWithConditionsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());

        }

        private List<Book> generateListOfNBooks(int booksQuantity) {
            List<Book> resultList = new ArrayList<>();
            for (int n = 1; n <= booksQuantity; n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                resultList.add(theBook);
            }
            return resultList;
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Test books in hands of")
    public class testBooksInHandsOf {

        @Test
        void testListBooksInHandsOfWithConditionEmptyResultList() {
            //Given
            List<Book> resultListOfBooks = new ArrayList<>();
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            LibraryUser libraryUser = new LibraryUser("Andrzej", "Hania", "2938420842");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);
            //When
            List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser);
            //Then
            assertEquals(0, theListOfBooks0.size());
        }

        @Test
        void testListBooksInHandsOfWithConditionExactlyOneBook() {
            //Given
            List<Book> resultListOfBooks = new ArrayList<>();
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Andrzej", "Hania", "2938420842");
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            Map<LibraryUser, Book> resultListOfOneRentedBook = new HashMap<>();
            resultListOfOneRentedBook.put(libraryUser, book4);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(1, theListOfBooks1.size());
        }

        @Test
        void testListBooksInHandsOfWithConditionExactlyFiveBooks() {
            //Given
            List<Book> resultListOfBooks = new ArrayList<>();
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Andrzej", "Hania", "2938420842");
            Book book1 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            Book book2 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book3 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book4 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book5 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            Map<LibraryUser, Book> resultListOfFiveRentedBook = new HashMap<>();
            resultListOfFiveRentedBook.put(libraryUser, book1);
            resultListOfFiveRentedBook.put(libraryUser, book2);
            resultListOfFiveRentedBook.put(libraryUser, book3);
            resultListOfFiveRentedBook.put(libraryUser, book4);
            resultListOfFiveRentedBook.put(libraryUser, book5);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(5, theListOfBooks5.size());
        }
    }
}
