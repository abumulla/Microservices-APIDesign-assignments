package com.example.demo.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.dto.ResponseDto;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    final Logger log = LoggerFactory.getLogger(UserService.class);

    public ResponseDto registerUser(Customer user) {

        ResponseDto responseDto = new ResponseDto();

        responseDto.setData(customerRepository.save(user));
        responseDto.setMsg("Registration Success!!");

        log.info("User registered Successfully!");

        return responseDto;
    }
}
