package com.neptune.orderservice.controller;

import com.neptune.orderservice.dto.GeneralResponse;
import com.neptune.orderservice.dto.OrderRequestDto;
import com.neptune.orderservice.dto.OrderResponseDto;
import com.neptune.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public GeneralResponse<OrderResponseDto> createOrder(@RequestBody OrderRequestDto requestDto) {
        return new GeneralResponse<>("order created successfully", orderService.createOrder(requestDto));
    }

    @GetMapping
    public GeneralResponse<List<OrderResponseDto>> getAllOrders(Pageable pageable) {
        return new GeneralResponse<>("orders fetched successfully", orderService.getAllOrders(pageable));
    }
}

