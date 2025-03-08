package com.neptune.orderservice.dto;

import com.neptune.orderservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private String id;
    private String productId;
    private String productName;
    private int quantity;
    private OrderStatus status;
}
