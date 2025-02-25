package com.neptune.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequest {
   private String product;
   private int quantity;
}
