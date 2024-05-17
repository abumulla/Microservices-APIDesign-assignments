package com.microservice.downstream.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BooksTest {

    @Test
    void testGetterAndSetter() {
        // Create an instance of Books
        Books book = new Books();

        // Set values using setter methods
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        // Verify values using getter methods
        assertEquals(1L, book.getId());
        assertEquals("Book Name", book.getName());
        assertEquals("Author", book.getAuthor());
        assertEquals("Description", book.getDescription());
        assertEquals(4.5, book.getRating());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances with same values
        Books book1 = new Books();
        book1.setId(1L);
        book1.setName("Book Name");
        book1.setAuthor("Author");
        book1.setDescription("Description");
        book1.setRating(4.5);

        Books book2 = new Books();
        book2.setId(1L);
        book2.setName("Book Name");
        book2.setAuthor("Author");
        book2.setDescription("Description");
        book2.setRating(4.5);

        // Verify equals method
        assertTrue(book1.equals(book2));
        assertTrue(book2.equals(book1));

        // Verify hashCode method
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testToString() {
        Books book = new Books();
        book.setId(1L);
        book.setName("Book Name");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setRating(4.5);

        String expectedToString = "Books(id=1, name=Book Name, author=Author, description=Description, rating=4.5)";
        assertEquals(expectedToString, book.toString());
    }
}
