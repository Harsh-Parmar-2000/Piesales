package com.piesales.cartService.payloads;

import java.util.List;
import lombok.Data;

@Data
public class ProductRequestDto {
    List<Integer> productIds;
}
