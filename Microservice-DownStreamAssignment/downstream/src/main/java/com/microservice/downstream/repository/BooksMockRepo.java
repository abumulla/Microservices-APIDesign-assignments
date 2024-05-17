package com.microservice.downstream.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class BooksMockRepo {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> mockAddBook() {
        String url = "http://localhost:8090/addBook";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response;
        } else {
            return new ResponseEntity<String>("Error in adding book!!", response.getStatusCode());
        }
    }

    public ResponseEntity<String> mockGetBook() {
        String url = "http://localhost:8090/getBook";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        
        if (response.getStatusCode() == HttpStatus.OK) {
            return response;
        } else {
            return new ResponseEntity<String>("Cannot find the book!!", response.getStatusCode());
        }
    }
}
