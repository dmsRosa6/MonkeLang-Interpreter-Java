package com.dummylang.exceptions;

public class BadNumberOfParamsException extends RuntimeException {

    public BadNumberOfParamsException(String s) {
        super(s);
    }
}
