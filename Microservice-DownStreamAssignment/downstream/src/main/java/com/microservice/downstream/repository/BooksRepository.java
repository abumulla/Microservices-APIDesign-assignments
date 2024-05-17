package com.microservice.downstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.downstream.model.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{
    
}
