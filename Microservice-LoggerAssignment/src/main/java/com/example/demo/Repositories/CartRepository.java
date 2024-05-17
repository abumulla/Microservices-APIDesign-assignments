package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Cart;

public interface CartRepository extends JpaRepository<Cart,UUID>{
    Optional<List<Cart>> findAllByCustomerId(long customerId);
}