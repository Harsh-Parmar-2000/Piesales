package com.piesales.productService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piesales.productService.entities.Products;

public interface ProductRepo extends JpaRepository<Products,Integer>{
    @Query("select p from Products p where p.id IN :productIds")
    List<Products> findAllProductsByIds(List<Integer> productIds);

    
}
