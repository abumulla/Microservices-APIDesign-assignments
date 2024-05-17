package com.microservice.downstream.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private long id;

    @Column(name = "bookName")
    private String name;
    
    @Column(name = "bookAuthor")
    private String author;

    @Column(name = "bookDescription")
    private String description;
    
    @Column(name = "bookRating")
    private double rating;

}
