package com.example.hsbc_test.converter.impl;

import com.example.hsbc_test.converter.NumberConverter;
import com.example.hsbc_test.exception.ConvertFailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NumberConverterImplTest {

    @Autowired
    NumberConverter numberConverter;

    @Test
    public void testErrorNumber1() {
        int[] arr = {-1};
        try {
            numberConverter.convert(arr);
        } catch (Exception e) {
            if (ConvertFailException.NUMBER_NOT_IN_RANGE.equals(e.getMessage())) {
                return;
            } else {
                System.out.println("unknown Exception:" + e.getMessage());
                e.printStackTrace();
                assert false;
            }
        }
        assert false;
    }

    @Test
    public void testErrorNumber2() {
        int[] arr = {10};
        try {
            numberConverter.convert(arr);
        } catch (Exception e) {
            if (ConvertFailException.NUMBER_NOT_IN_RANGE.equals(e.getMessage())) {
                assert true;
                return;
            } else {
                System.out.println("unknown Exception:" + e.getMessage());
                e.printStackTrace();
                assert false;
            }
        }
        System.out.println("testErrorNumber2 fail");
        assert false;
    }

    @Test
    public void testNullInput() {
        try {
            numberConverter.convert(null);
        } catch (Exception e) {
            if (ConvertFailException.INPUT_IS_NULL.equals(e.getMessage())) {
                assert true;
                return;
            } else {
                System.out.println("unknown Exception:" + e.getMessage());
                e.printStackTrace();
                assert false;
            }
        }
        System.out.println("testNullInput fail");
        assert false;
    }

    @Test
    public void testSuccess() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        try {
            List<String> result= numberConverter.convert(arr);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("testNullInput fail" + e.getMessage());
            e.printStackTrace();
            assert false;
        }
        assert true;
    }

}