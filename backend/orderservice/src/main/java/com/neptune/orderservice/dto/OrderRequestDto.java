package com.neptune.orderservice.dto;


import lombok.Data;

@Data
public class OrderRequestDto {
    private String product;
    private int quantity;
}
