package com.piesales.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.piesales.orderService.payloads.OrderPlaceDto;
import com.piesales.orderService.payloads.OrderWithProductsDto;
import com.piesales.orderService.services.OrderService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/health")
    public String publicEndpoint() {
        return "Order Service is working as expected.";
    }

    @PostMapping("/checkout/{userId}")
    public ResponseEntity<String> checkOut(@PathVariable Integer userId,@RequestBody OrderPlaceDto orderPlaceDto) {
        this.orderService.checkOut(userId,orderPlaceDto.getCheckoutOrders());
        return new ResponseEntity<String>("Thanks For Order", HttpStatus.OK);
    }

    @GetMapping("/getMyOrders/{userId}")
    public ResponseEntity<List<OrderWithProductsDto>> getMyOrders(@PathVariable Integer userId) {
        List<OrderWithProductsDto> response = this.orderService.getMyOrders(userId);
        return new ResponseEntity<List<OrderWithProductsDto>>(response, HttpStatus.OK);
    }
    
}