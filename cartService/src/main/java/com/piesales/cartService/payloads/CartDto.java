package com.piesales.cartService.payloads;

import lombok.Data;

@Data
public class CartDto {
    int quantity;
    ProductDto product;
}
