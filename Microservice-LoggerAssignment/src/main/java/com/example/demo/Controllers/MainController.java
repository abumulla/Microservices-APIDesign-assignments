package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Cart;
import com.example.demo.Models.Product;
import com.example.demo.Services.CartService;
import com.example.demo.Services.ProductSerivce;
import com.example.demo.Services.UserService;
import com.example.demo.dto.ResponseDto;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("api/v1")
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ProductSerivce productSerivce;

    @Autowired
    CartService cartService;

    @PostMapping("/registerCustomer")
    public ResponseEntity<ResponseDto> register(@RequestBody Customer customer) {
        return new ResponseEntity<ResponseDto>(userService.registerUser(customer), HttpStatus.CREATED);
    }


    @PostMapping("/addProduct")
    public ResponseEntity<ResponseDto> createproduct(@RequestBody Product product) {
        return new ResponseEntity<ResponseDto>(productSerivce.addProducts(product), HttpStatus.CREATED);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProd() {
        return new ResponseEntity<List<Product>>(productSerivce.getProducts(),HttpStatus.OK);
    }
    
    
    @PostMapping("/addItemToCart")
    public ResponseEntity<ResponseDto> addToCart(@RequestHeader UUID productId, @RequestHeader long customerId) {
        return new ResponseEntity<ResponseDto>(cartService.addItemToCart(productId, customerId), HttpStatus.CREATED);
    }
    
    @GetMapping("/cart/getItems")
    public ResponseEntity<List<Cart>> getCarts(@RequestParam long customerId, @RequestParam String customerName) {
        return new ResponseEntity<List<Cart>>(cartService.getCartItems(customerId),HttpStatus.OK);
    }
}
