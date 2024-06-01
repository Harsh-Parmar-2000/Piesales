package com.piesales.productService.services;

import com.piesales.productService.entities.Products;
import com.piesales.productService.payloads.ProductRequestDto;
import com.piesales.productService.payloads.ProductResponseDto;

public interface ProductService {
    Products addProduct(Products products);

    String addToCart(int productId);

    ProductResponseDto getProductsByProductIds(ProductRequestDto productRequestDto);
}
