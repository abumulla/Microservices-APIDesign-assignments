package com.microservice.downstream.controller;

import com.microservice.downstream.model.Books;
import com.microservice.downstream.service.BooksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private BooksService booksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookId() {
        Books book = new Books();
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        when(booksService.getBookById(anyLong())).thenReturn(book);

        ResponseEntity<Books> response = mainController.getBookId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void testAddBookToDb() {
        Books book = new Books();
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        when(booksService.addBook(any(Books.class))).thenReturn("Book added successfully!!");

        ResponseEntity<String> response = mainController.addBookToDb(book);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Book added successfully!!", response.getBody());
    }

    @Test
    void testMockGetBookId() {
        when(booksService.mockGetBookById()).thenReturn(new ResponseEntity<>("Mock Book Response", HttpStatus.OK));

        ResponseEntity<String> response = mainController.mockGetBookId();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Mock Book Response", response.getBody());
    }

    @Test
    void testMockAddBooks() {
        when(booksService.mockAddNewBook()).thenReturn(new ResponseEntity<>("Mock Add Book Response", HttpStatus.CREATED));

        ResponseEntity<String> response = mainController.mockAddBooks();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Mock Add Book Response", response.getBody());
    }
}
