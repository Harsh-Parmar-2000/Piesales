package com.piesales.orderService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piesales.orderService.enitities.OrderProductsMap;

public interface OrderProductsMapRepo extends JpaRepository<OrderProductsMap,Integer>{
    @Query("SELECT opm FROM OrderProductsMap opm WHERE opm.orderId=:orderId")
    List<OrderProductsMap> findProductsOfEachOrder(@Param("orderId") int orderId);
}
