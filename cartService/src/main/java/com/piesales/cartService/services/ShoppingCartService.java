package com.piesales.cartService.services;

import java.util.List;

import com.piesales.cartService.entities.ShoppingCart;
import com.piesales.cartService.payloads.CartDto;

public interface ShoppingCartService {
    ShoppingCart addToCart(ShoppingCart shoppingCart);  

    List<CartDto> getMyCart(int userId);

    void emptyMyCart(int userId);
    
    void removeProductFromCart(int userId,int productId);
}
