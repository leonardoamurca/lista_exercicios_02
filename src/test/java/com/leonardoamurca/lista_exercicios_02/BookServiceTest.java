package com.leonardoamurca.lista_exercicios_02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {

    // Unit tests
    @Test
    public void shouldInsertBookSuccesfully() {
        // Arrange
        Book book = new Book(1, "Clean Code", "Sofware Engineering");
        BookService service = new BookService(new MockedDB());

        // Act
        service.addBook(book);
        service.addBook(book);
        service.addBook(book);
        service.addBook(book);
        boolean result = service.addBook(book);

        // Assert
        assertTrue(result);
    }

    @Test
    public void shouldRemoveBookSuccesfully() {
        // Arrange
        int bookId = 1;
        BookService service = new BookService(new MockedDB());

        // Act
        boolean result = service.remove(bookId);

        // Assert
        assertTrue(result);
    }

    // Integration Tests
    @Test
    public void shouldInsertBookSuccesfullyIntegrationTest() {
        // Arrange
        Book book = new Book(1, "Clean Code", "Sofware Engineering");
        BookService service = new BookService(new DB());

        // Act
        service.addBook(book);
        service.addBook(book);
        service.addBook(book);
        service.addBook(book);
        boolean result = service.addBook(book);

        // Assert
        assertTrue(result);
    }

    @Test
    public void shouldRemoveBookSuccesfullyIntegrationTest() {
        // Arrange
        int bookId = 1;
        BookService service = new BookService(new DB());

        // Act
        boolean result = service.remove(bookId);

        // Assert
        assertTrue(result);
    }

}