package com.neptune.orderservice.dto;

import com.neptune.orderservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private String product;
    private int quantity;
    private OrderStatus status;

}
