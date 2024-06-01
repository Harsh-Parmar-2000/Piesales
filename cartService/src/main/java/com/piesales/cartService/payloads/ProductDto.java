package com.piesales.cartService.payloads;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String productCategory;
    private String productImage;
}
