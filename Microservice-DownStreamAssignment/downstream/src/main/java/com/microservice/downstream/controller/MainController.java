package com.microservice.downstream.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.downstream.model.Books;
import com.microservice.downstream.service.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1")
public class MainController {
    @Autowired
    BooksService booksService;

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Books> getBookId(@PathVariable("id") long id) {
        return new ResponseEntity<Books>(booksService.getBookById(id),HttpStatus.OK);
    }
    
    @PostMapping("/addbook")
    public ResponseEntity<String> addBookToDb(@RequestBody Books book) {
        return new ResponseEntity<String>(booksService.addBook(book),HttpStatus.CREATED);
    }
    
    @GetMapping("/mockGetBook")
    public ResponseEntity<String> mockGetBookId(){
        return booksService.mockGetBookById();
    }

    @PostMapping("/mockAddBook")
    public ResponseEntity<String> mockAddBooks() {
        return booksService.mockAddNewBook();
    }
    
}
