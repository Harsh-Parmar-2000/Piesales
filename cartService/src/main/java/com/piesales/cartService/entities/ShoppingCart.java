package com.piesales.cartService.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ShoppingCart {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private int productId;
    private int userId;
    private int quantity;
}
