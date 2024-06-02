package com.piesales.productService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piesales.productService.entities.Products;
import com.piesales.productService.payloads.ProductRequestDto;
import com.piesales.productService.payloads.ProductResponseDto;
import com.piesales.productService.repositories.ProductRepo;
import com.piesales.productService.services.ProductService;

@RestController
@RequestMapping("/api/")
// @CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductService productService;

    @GetMapping("/health")
    public String publicEndpoint() {
        return "Product Service is working as expected.";
    }

    @GetMapping("/health/123")
	public String checkToken() {
		return this.productService.addToCart(0);
		
	}

    @GetMapping("/getAllProducts")
    public List<Products> secureEndpoint() {
        return this.productRepo.findAll();
    }

    @PostMapping("/addProduct")
	public ResponseEntity<Products> createUser(@Valid @RequestBody Products products) {
		Products createUserDto = this.productService.addProduct(products);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

    @PostMapping("/getProductsInMyCart")
    public ResponseEntity<ProductResponseDto> getProductsByProductIds(@RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto response = this.productService.getProductsByProductIds(productRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}