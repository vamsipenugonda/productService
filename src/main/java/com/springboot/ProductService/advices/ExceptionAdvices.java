package com.springboot.ProductService.advices;

import com.springboot.ProductService.dtos.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handleRuntimeException(RuntimeException e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setStatus("ERROR");
        return errorResponseDTO;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "Something went Wrong";
    }
}
