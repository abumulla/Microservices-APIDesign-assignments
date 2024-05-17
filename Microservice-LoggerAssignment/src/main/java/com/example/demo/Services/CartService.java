package com.example.demo.Services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Cart;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.CartRepository;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.dto.ResponseDto;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseDto addItemToCart(UUID productId, long customerId) {
        Cart newCartItem = new Cart();

        newCartItem.setCustomerId(customerId);
        newCartItem.setProductId(productId);
        
        Product product = productRepository.findById(productId).get();
        newCartItem.setProductName(product.getProductName());
        
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(cartRepository.save(newCartItem));
        responseDto.setMsg("Product added to cart!!");
        
        final Logger log = LoggerFactory.getLogger(CartService.class);
        log.info("Product added to cart");
        
        return responseDto;
    }

    public List<Cart> getCartItems(long customerId) {
        return cartRepository.findAllByCustomerId(customerId).get();
    }
}
