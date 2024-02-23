package com.nhnacademy.mini.dooray;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}