package com.example.demo.exception;

public class NonSaved extends RuntimeException {
    public NonSaved(String s) {
        super(s);
    }
}
