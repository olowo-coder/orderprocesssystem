package com.neptune.inventoryservice.grpc;


import com.neptune.inventoryservice.service.InventoryService;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl extends com.neptune.inventoryservice.grpc.InventoryServiceGrpc.InventoryServiceImplBase {

    private final InventoryService inventoryService;

    @Override
    public void checkStock(com.neptune.inventoryservice.grpc.Inventory.InventoryRequest request, StreamObserver<com.neptune.inventoryservice.grpc.Inventory.InventoryResponse> responseObserver) {
        log.info("Checking stock for product: {}", request.getProduct());

        boolean isAvailable = inventoryService.checkStock(request.getProduct(), request.getQuantity());

        com.neptune.inventoryservice.grpc.Inventory.InventoryResponse response = com.neptune.inventoryservice.grpc.Inventory.InventoryResponse.newBuilder()
            .setAvailable(isAvailable)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

