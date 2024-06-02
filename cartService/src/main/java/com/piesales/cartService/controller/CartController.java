package com.piesales.cartService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piesales.cartService.entities.ShoppingCart;
import com.piesales.cartService.payloads.CartDto;
import com.piesales.cartService.services.ShoppingCartService;

@RestController
// @CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/cart/api/addToCart")
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody ShoppingCart shoppingCart) {
        this.shoppingCartService.addToCart(shoppingCart);
        return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
    }

    @GetMapping("/cart/api/getMyCart/{userId}")
    public ResponseEntity<List<CartDto>> getMyCart(@PathVariable("userId") Integer userId){
        List<CartDto> myCart = this.shoppingCartService.getMyCart(userId);
        return new ResponseEntity<List<CartDto>>(myCart, HttpStatus.OK);
    }
    
    @DeleteMapping("/cart/api/emptyCart/{userId}")
    public ResponseEntity<String> emptyMyCart(@PathVariable Integer userId){
        this.shoppingCartService.emptyMyCart(userId);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/cart/api/removeFromCart/{userId}/{productId}")
    public ResponseEntity<String> removeFromMyCart(@PathVariable("userId") Integer userId,@PathVariable("productId") Integer productId){
        this.shoppingCartService.removeProductFromCart(userId,productId);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }
}
