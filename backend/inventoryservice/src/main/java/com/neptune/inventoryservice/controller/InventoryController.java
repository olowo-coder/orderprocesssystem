package com.neptune.inventoryservice.controller;

import com.neptune.inventoryservice.dto.GeneralResponse;
import com.neptune.inventoryservice.dto.ProductDto;
import com.neptune.inventoryservice.model.Product;
import com.neptune.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("*")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/products")
    public GeneralResponse<List<ProductDto>> getAllProducts(Pageable pageable) {
        return new GeneralResponse<>( "products fetched successfully", inventoryService.getAllProducts(pageable));
    }
}

