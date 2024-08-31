package com.springboot.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponseDTO {
    public String status;
    public String message;
}
