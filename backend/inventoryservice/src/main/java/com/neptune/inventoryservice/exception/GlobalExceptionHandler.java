package com.neptune.inventoryservice.exception;

import com.neptune.inventoryservice.dto.GeneralResponse;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<Object> handleGrpcException(StatusRuntimeException ex) {
        log.error("gRPC Error:", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new GeneralResponse<>("Inventory Service Error", false));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        log.error("Unexpected Error:", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new GeneralResponse<>("An unexpected error occurred", false));
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Object> handleBadRequestException(ProductException ex) {
        log.error("Unexpected Error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new GeneralResponse<>(ex.getMessage(), false));
    }
}
