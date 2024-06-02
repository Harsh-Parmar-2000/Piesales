package com.piesales.cartService.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piesales.cartService.entities.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart,Integer>{
    @Query("Select sc from ShoppingCart sc Where sc.userId =:userId And sc.productId =:productId")
    ShoppingCart findByUserIdAndProductId(@Param("userId") int userId,@Param("productId") int productId);
    
    @Query("Select sc from ShoppingCart sc Where sc.userId =:userId")
    List<ShoppingCart> findCart(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ShoppingCart sc WHERE sc.userId =:userId")
    void emptyMyCart(@Param("userId") int userId);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM ShoppingCart sc WHERE sc.userId =:userId AND sc.productId =:productId")
    void removeProductFromCart(@Param("userId") int userId,@Param("productId") int productId);
}
