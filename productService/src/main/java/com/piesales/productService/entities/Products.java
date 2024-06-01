package com.piesales.productService.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Products {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String productCategory;
    private String productImage;
    
}
