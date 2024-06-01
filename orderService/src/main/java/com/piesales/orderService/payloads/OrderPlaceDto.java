package com.piesales.orderService.payloads;

import lombok.Data;
import java.util.List;

@Data
public class OrderPlaceDto {
    int discount;
    List<OrderDetailsDto> checkoutOrders;
}
