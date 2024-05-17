package com.example.demo.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Product;

public interface ProductRepository extends JpaRepository<Product,UUID> {
    
}
