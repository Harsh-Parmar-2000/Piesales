package com.piesales.orderService.payloads;

import lombok.Data;

@Data
public class OrderDetailsDto {
    int quantity;
    ProductDto product;
}
