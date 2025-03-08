package com.neptune.inventoryservice.service;

import com.neptune.inventoryservice.dto.ProductDto;
import com.neptune.inventoryservice.model.Product;
import com.neptune.inventoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final ProductRepository productRepository;

    @PostConstruct
    private void init() {
        Product product1 = Product.builder()
            .name("coke")
            .stockQuantity(3)
            .build();

        Product product2 = Product.builder()
            .name("book")
            .stockQuantity(5)
            .build();

        Product product3 = Product.builder()
            .name("iphone 16")
            .stockQuantity(2)
            .build();

        productRepository.saveAll(List.of(product1, product2, product3));
    }

    @Transactional
    public boolean checkStock(String productId, int quantity) {
        return productRepository.findById(productId)
            .filter(product -> product.getStockQuantity() >= quantity)
            .map(product -> {
                product.setStockQuantity(product.getStockQuantity() - quantity);
                productRepository.save(product);
                return true;
            })
            .orElse(false);
    }

    private ProductDto mapToDto(Product product) {
        return ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .stockQuantity(product.getStockQuantity())
            .build();
    }

    public List<ProductDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }
}

