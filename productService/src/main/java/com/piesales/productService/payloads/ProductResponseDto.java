package com.piesales.productService.payloads;

import java.util.List;

import com.piesales.productService.entities.Products;

import lombok.Data;

@Data
public class ProductResponseDto {
    List<Products> productsInCart;
}