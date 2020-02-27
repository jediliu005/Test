package com.example.hsbc_test.converter;

import com.example.hsbc_test.exception.ConvertFailException;

import java.util.List;

public abstract class NumberConverter {
    protected static final String[][] mapingArrays={{},{},{"A","B","C"},{"D","E","F"},{"G","H","I"},{"J","K","L"},{"M","N","O"},{"P","Q","R","S"},{"T","U","V"},{"W","X","Y","Z"}};
    public abstract  List<String> convert(int[] inputArr) throws Exception;
    protected void validateInput(int[] inputArr) {
        if (inputArr == null) {
            throw new ConvertFailException(ConvertFailException.INPUT_IS_NULL);
        }
        for (int i = 0; i < inputArr.length; i++) {
            int num = inputArr[i];
            if (num < 0 || num > 9) {
                throw new ConvertFailException(ConvertFailException.NUMBER_NOT_IN_RANGE);
            }
        }
    }
}

