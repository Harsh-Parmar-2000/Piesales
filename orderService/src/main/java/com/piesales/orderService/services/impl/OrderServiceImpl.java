package com.piesales.orderService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.piesales.orderService.config.TokenManager;
import com.piesales.orderService.enitities.OrderProductsMap;
import com.piesales.orderService.enitities.Orders;
import com.piesales.orderService.payloads.OrderDetailsDto;
import com.piesales.orderService.payloads.OrderWithProductsDto;
import com.piesales.orderService.payloads.ProductDto;
import com.piesales.orderService.payloads.ProductRequestDto;
import com.piesales.orderService.payloads.ProductResponseDto;
import com.piesales.orderService.repositories.OrderProductsMapRepo;
import com.piesales.orderService.repositories.OrderRepo;
import com.piesales.orderService.services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderProductsMapRepo orderProductsMapRepo;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    TokenManager tokenManager;

    Long price = 0L;

    @Override
    public List<OrderDetailsDto> checkOut(Integer userId,List<OrderDetailsDto> cart){
        String token = tokenManager.getToken();
        Orders saveOrder = new Orders();
        saveOrder.setOrderStatus("Placed");
        saveOrder.setUserId(userId);
        price = 0L;
        cart.stream().forEach(c->{
            price += (c.getQuantity() * c.getProduct().getProductPrice());
        });
        saveOrder.setOrderPrice(price);
        Orders savedOrder = this.orderRepo.save(saveOrder);
        cart.stream().forEach(c->{
            OrderProductsMap mapProductWithOrder = new OrderProductsMap();
            mapProductWithOrder.setOrderId(savedOrder.getId());
            mapProductWithOrder.setQuantity(c.getQuantity());
            mapProductWithOrder.setProductId(c.getProduct().getId());
            this.orderProductsMapRepo.save(mapProductWithOrder);
        });
        System.out.println("token "+token);
        String url = "http://localhost:9093/cart/api/emptyCart/"+userId;
        HttpHeaders headers = new HttpHeaders();
        
        headers.set("Authorization", "Bearer "+token);
    
        HttpEntity<?> entity = new HttpEntity<>(headers);

        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
       
        return cart;
    }

    @Override
    public List<OrderWithProductsDto> getMyOrders(int userId){
        List<OrderWithProductsDto> response = new ArrayList<>();
        String token = tokenManager.getToken();
        List<Orders> allOrdersOfUser = this.orderRepo.findAllOrdersOfUser(userId);
        for(Orders eachOrder : allOrdersOfUser){
            List<OrderProductsMap> productsOfEachOrder = this.orderProductsMapRepo.findProductsOfEachOrder(eachOrder.getId());
            List<Integer> productIdsOfEachOrder = productsOfEachOrder.stream().map(p->p.getProductId()).collect(Collectors.toList());
            String url = "http://localhost:9092/product/api/getProductsInMyCart";
            ProductRequestDto requestingForProductDetails = new ProductRequestDto();
            requestingForProductDetails.setProductIds(productIdsOfEachOrder);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Authorization", "Bearer "+token);
            HttpEntity<ProductRequestDto> entity = new HttpEntity<>(requestingForProductDetails, headers);
            ResponseEntity<ProductResponseDto> allProducts = restTemplate.exchange(url, HttpMethod.POST, entity, ProductResponseDto.class);
            OrderWithProductsDto addToResponse = new OrderWithProductsDto();
            addToResponse.setId(eachOrder.getId());
            addToResponse.setOrderPrice(eachOrder.getOrderPrice());
            addToResponse.setOrderStatus(eachOrder.getOrderStatus());
            List<ProductDto> products = allProducts.getBody().getProductsInCart();
            List<OrderDetailsDto> allOrdersWithProducts = new ArrayList<OrderDetailsDto>();
            for(OrderProductsMap productMap:productsOfEachOrder){
                OrderDetailsDto addProductWithQuantity = new OrderDetailsDto();
                ProductDto setProduct = products.stream().filter(product->productMap.getProductId()==product.getId()).findFirst().get();
                addProductWithQuantity.setProduct(setProduct);
                addProductWithQuantity.setQuantity(productMap.getQuantity());
                allOrdersWithProducts.add(addProductWithQuantity);
            }
            addToResponse.setProductDetails(allOrdersWithProducts);
            response.add(addToResponse);
        }
        return response;
    }
}
