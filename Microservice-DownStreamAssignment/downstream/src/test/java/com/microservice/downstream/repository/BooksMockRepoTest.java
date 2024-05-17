package com.microservice.downstream.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BooksMockRepoTest {

    @InjectMocks
    private BooksMockRepo booksMockRepo;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testMockAddBook() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Mock Add Book Response", HttpStatus.CREATED);

        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(Class.class)))
                .thenReturn(responseEntity);

        ResponseEntity<String> response = booksMockRepo.mockAddBook();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Mock Add Book Response", response.getBody());
    }

    @SuppressWarnings("unchecked")
    @Test
    void testMockGetBook() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Mock Get Book Response", HttpStatus.OK);

        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(Class.class)))
                .thenReturn(responseEntity);

        ResponseEntity<String> response = booksMockRepo.mockGetBook();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Mock Get Book Response", response.getBody());
    }
}
