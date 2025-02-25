package com.neptune.orderservice.service;

import com.neptune.orderservice.dto.OrderRequest;
import com.neptune.orderservice.enums.OrderStatus;
import com.neptune.orderservice.model.Order;
import com.neptune.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setProduct(orderRequest.getProduct());
        order.setQuantity(orderRequest.getQuantity());
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
