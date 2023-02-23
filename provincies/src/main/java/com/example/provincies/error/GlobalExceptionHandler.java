package com.example.provincies.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception ex, Model model){
        model.addAttribute("errorMessage",ex.getMessage());
        return "error";
    }
}
