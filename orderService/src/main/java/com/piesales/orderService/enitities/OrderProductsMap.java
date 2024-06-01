package com.piesales.orderService.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderProductsMap {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private int orderId;
    private int productId;
    private int quantity;
}
