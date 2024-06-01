package com.piesales.productService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piesales.productService.config.TokenManager;
import com.piesales.productService.entities.Products;
import com.piesales.productService.payloads.JwtAuthRequest;
import com.piesales.productService.payloads.ProductRequestDto;
import com.piesales.productService.payloads.ProductResponseDto;
import com.piesales.productService.repositories.ProductRepo;
import com.piesales.productService.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
     

    @Autowired
    private TokenManager tokenManager;

    // public String addToCart(int productId) {
    //     String token = tokenManager.getToken();

    //    String url = "https://localhost:9093/cart/api/addToCart/" + productId;

    //     // Create headers
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "Bearer " + token);

    //     // Create the entity with the headers and empty body
    //     HttpEntity<Void> entity = new HttpEntity<>(headers);

    //     // Make the POST request
    //     ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

    //     // Return the response body
    //     return response.getBody();
    //     return webClient.post()
    //             .uri("/api/addToCart/{productId}",productId)
    //             .header("Authorization", "Bearer " + token)
    //             .bodyValue(BodyInserters.empty())
    //             .retrieve()
    //             .bodyToMono(String.class)
    //             .block();
    // }

    public String addToCart(int productId) {
        String token = tokenManager.getToken();
        return token;
    }

    public Products addProduct(Products products){
        return this.productRepo.save(products);
	}  

    public ProductResponseDto getProductsByProductIds(ProductRequestDto productRequestDto){
        List<Products> allProductsOfCart = this.productRepo.findAllProductsByIds(productRequestDto.getProductIds());
        ProductResponseDto response = new ProductResponseDto();
        response.setProductsInCart(allProductsOfCart);
        return response;
    }
}