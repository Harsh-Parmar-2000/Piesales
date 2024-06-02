package com.piesales.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piesales.orderService.enitities.Orders;
import java.util.List;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
    @Query("SELECT o FROM Orders o WHERE o.userId =:userId")
    List<Orders> findAllOrdersOfUser(@Param("userId") int userId);
}
