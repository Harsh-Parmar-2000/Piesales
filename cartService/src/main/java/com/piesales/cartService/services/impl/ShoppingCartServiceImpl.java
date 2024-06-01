package com.piesales.cartService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.piesales.cartService.config.TokenManager;
import com.piesales.cartService.entities.ShoppingCart;
import com.piesales.cartService.payloads.CartDto;
import com.piesales.cartService.payloads.ProductDto;
import com.piesales.cartService.payloads.ProductRequestDto;
import com.piesales.cartService.payloads.ProductResponseDto;
import com.piesales.cartService.repositories.ShoppingCartRepo;
import com.piesales.cartService.services.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TokenManager tokenManager;

    @Override
    public ShoppingCart addToCart(ShoppingCart shoppingCart){
        ShoppingCart productAvlInCart = this.shoppingCartRepo.findByUserIdAndProductId(shoppingCart.getUserId(),shoppingCart.getProductId());
        if(productAvlInCart != null){
            if(shoppingCart.getQuantity() == 1){
                productAvlInCart.setQuantity(productAvlInCart.getQuantity()+1);
            }else{
                productAvlInCart.setQuantity(shoppingCart.getQuantity());
            }
        }
        else{
            productAvlInCart = shoppingCart;
        }
        return shoppingCartRepo.save(productAvlInCart);
    }

    @Override
    public List<CartDto> getMyCart(int userId){
        String token = tokenManager.getToken();
        List<ShoppingCart> cartOfUser = this.shoppingCartRepo.findCart(userId);

        List<Integer> productIdsFromCart = cartOfUser.stream().map(pIds->pIds.getProductId()).collect(Collectors.toList());
        String url = "http://localhost:9092/product/api/getProductsInMyCart";
        ProductRequestDto requestingForProductDetails = new ProductRequestDto();
        requestingForProductDetails.setProductIds(productIdsFromCart);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer "+token);
        HttpEntity<ProductRequestDto> entity = new HttpEntity<>(requestingForProductDetails, headers);
        ResponseEntity<ProductResponseDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, ProductResponseDto.class);
        List<ProductDto> products = response.getBody().getProductsInCart();
        List<CartDto> cartResponse = new ArrayList<>();
        for(ShoppingCart cartDetails : cartOfUser){
            CartDto addProductWithQuantity = new CartDto();
            ProductDto setProduct = products.stream().filter(product->cartDetails.getProductId()==product.getId()).findFirst().get();
            addProductWithQuantity.setProduct(setProduct);
            addProductWithQuantity.setQuantity(cartDetails.getQuantity());
            cartResponse.add(addProductWithQuantity);
        }
        return cartResponse;
    }

    @Override
    public void emptyMyCart(int userId){
        this.shoppingCartRepo.emptyMyCart(userId);
    }

    
    @Override
    public void removeProductFromCart(int userId,int productId){
        this.shoppingCartRepo.removeProductFromCart(userId,productId);
    }

}
