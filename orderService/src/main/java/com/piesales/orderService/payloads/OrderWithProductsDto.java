package com.piesales.orderService.payloads;

import java.util.List;

import lombok.Data;

@Data
public class OrderWithProductsDto {
    private int id;
    private Long orderPrice;
    private String orderStatus;
    private List<OrderDetailsDto> productDetails;
}
