package com.example.demo.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.dto.ResponseDto;

@Service
public class ProductSerivce {

    @Autowired
    private ProductRepository productRepository;

    public ResponseDto addProducts(Product product) {

        final Logger log = LoggerFactory.getLogger(ProductSerivce.class);

        ResponseDto responseDto = new ResponseDto();

        responseDto.setData(productRepository.save(product));
        responseDto.setMsg("Product added successfully");

        log.info("Product added successfully");

        return responseDto;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
