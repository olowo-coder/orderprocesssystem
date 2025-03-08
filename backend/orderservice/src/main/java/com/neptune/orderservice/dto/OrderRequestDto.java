package com.neptune.orderservice.dto;


import lombok.Data;

@Data
public class OrderRequestDto {
    private String productId;
    private String productName;
    private int quantity;
}
