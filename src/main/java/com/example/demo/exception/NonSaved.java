package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class NonSaved extends RuntimeException {
    public NonSaved(String s) {
        super(s);
    }
}
