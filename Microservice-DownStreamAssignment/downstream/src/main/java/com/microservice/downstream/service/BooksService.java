package com.microservice.downstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.downstream.model.Books;
import com.microservice.downstream.repository.BooksMockRepo;
import com.microservice.downstream.repository.BooksRepository;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BooksMockRepo booksMockRepo;

    // DB based services
    public Books getBookById(long id){
        return booksRepository.findById(id).get();
    }

    public String addBook(Books book){
        booksRepository.save(book);
        return "Book added successfully!!";
    }


    // Mock based services
    public ResponseEntity<String> mockGetBookById(){
        ResponseEntity<String> response = booksMockRepo.mockGetBook();
        return response;
    }

    public ResponseEntity<String> mockAddNewBook(){
        ResponseEntity<String> response = booksMockRepo.mockAddBook();
        return response;
    }
}
