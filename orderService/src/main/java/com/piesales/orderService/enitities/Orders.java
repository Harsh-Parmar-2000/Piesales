package com.piesales.orderService.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Orders {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String orderStatus;
    private Long orderPrice;
    private int userId;
}
