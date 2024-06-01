package com.piesales.orderService.services;

import com.piesales.orderService.payloads.OrderDetailsDto;
import com.piesales.orderService.payloads.OrderWithProductsDto;

import java.util.List;

public interface OrderService {
    List<OrderDetailsDto> checkOut(Integer userId,List<OrderDetailsDto> cart); 

    List<OrderWithProductsDto> getMyOrders(int userId);
}
