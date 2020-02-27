package com.example.hsbc_test.exception;

public class ConvertFailException extends RuntimeException {
    public static final String NUMBER_NOT_IN_RANGE="can deal only 0-9 Integer Number";
    public static final String INPUT_IS_NULL="input is null";
    public ConvertFailException(String message) {
        super(message);
    }
}
