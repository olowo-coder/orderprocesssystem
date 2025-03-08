package com.neptune.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse<T>{
    private String message;
    private boolean success;
    private T data;

    public GeneralResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public GeneralResponse(String message, T data) {
        this.message = message;
        this.success = true;
        this.data = data;
    }
}
