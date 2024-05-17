package com.microservice.downstream.service;

import com.microservice.downstream.model.Books;
import com.microservice.downstream.repository.BooksMockRepo;
import com.microservice.downstream.repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class BooksServiceTest {

    @InjectMocks
    private BooksService booksService;

    @Mock
    private BooksRepository booksRepository;

    @Mock
    private BooksMockRepo booksMockRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookById() {
        Books book = new Books();
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        when(booksRepository.findById(anyLong())).thenReturn(Optional.of(book));

        Books result = booksService.getBookById(1L);

        assertEquals(book, result);
    }

    @Test
    void testAddBook() {
        Books book = new Books();
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        when(booksRepository.save(book)).thenReturn(book);

        String result = booksService.addBook(book);

        assertEquals("Book added successfully!!", result);
    }

    @Test
    void testMockGetBookById() {
        when(booksMockRepo.mockGetBook()).thenReturn(new ResponseEntity<>("Mock Book Response", HttpStatus.OK));

        ResponseEntity<String> response = booksService.mockGetBookById();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Mock Book Response", response.getBody());
    }

    @Test
    void testMockAddNewBook() {
        when(booksMockRepo.mockAddBook()).thenReturn(new ResponseEntity<>("Mock Add Book Response", HttpStatus.CREATED));

        ResponseEntity<String> response = booksService.mockAddNewBook();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Mock Add Book Response", response.getBody());
    }
}
