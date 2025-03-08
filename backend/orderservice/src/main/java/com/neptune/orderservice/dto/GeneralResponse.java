package com.neptune.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse <T>{
    private String message;
    private boolean success;
    private T data;

    public GeneralResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public GeneralResponse(T data) {
        this.message = "success";
        this.success = true;
        this.data = data;
    }
}
