package com.neptune.orderservice.service;

import com.neptune.inventoryservice.grpc.Inventory;
import com.neptune.inventoryservice.grpc.InventoryServiceGrpc;
import com.neptune.orderservice.dto.OrderRequestDto;
import com.neptune.orderservice.dto.OrderResponseDto;
import com.neptune.orderservice.enums.OrderStatus;
import com.neptune.orderservice.exception.OrderException;
import com.neptune.orderservice.model.Order;
import com.neptune.orderservice.repository.OrderRepository;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    @GrpcClient("inventory-service")
    private InventoryServiceGrpc.InventoryServiceBlockingStub inventoryClient;

    /**
     * Handles order creation by checking stock with Inventory Service.
     */
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        log.info("Processing order: {}", requestDto);

        Inventory.InventoryRequest inventoryRequest = Inventory.InventoryRequest.newBuilder()
            .setProduct(requestDto.getProductId())
            .setQuantity(requestDto.getQuantity())
            .build();
        Inventory.InventoryResponse inventoryResponse = inventoryClient.checkStock(inventoryRequest);

        if (!inventoryResponse.getAvailable()) {
            throw new OrderException("Stock Not Available");
        }

        // Save order if stock is available
        Order order = Order.builder()
            .productId(requestDto.getProductId())
            .productName(requestDto.getProductName())
            .quantity(requestDto.getQuantity())
            .status(OrderStatus.COMPLETED)
            .build();

        orderRepository.save(order);

        return mapToDto(order);
    }

    /**
     * Retrieves all orders.
     */
    public List<OrderResponseDto> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    private OrderResponseDto mapToDto(Order order) {
        return OrderResponseDto.builder()
            .id(order.getId())
            .productId(order.getProductId())
            .productName(order.getProductName())
            .quantity(order.getQuantity())
            .status(order.getStatus())
            .build();
    }
}
