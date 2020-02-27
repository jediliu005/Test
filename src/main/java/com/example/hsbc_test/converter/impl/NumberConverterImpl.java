package com.example.hsbc_test.converter.impl;

import com.example.hsbc_test.converter.NumberConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumberConverterImpl extends NumberConverter {


    @Override
    public List<String> convert(int[] inputArr) throws Exception {
        validateInput(inputArr);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            int num = inputArr[i];
            String[] matchStringArr = mapingArrays[num];
            if(matchStringArr.length==0){
                continue;
            }
            if (resultList.size() == 0) {
                for (String str : matchStringArr) {
                    resultList.add(str);
                }
            } else {
                List<String> tempResultList = new ArrayList<>();
                for (String existStr : resultList) {
                    for (String matchStr : matchStringArr) {
                        tempResultList.add(existStr + matchStr);
                    }
                }
                resultList = tempResultList;
            }
        }
        return resultList;
    }


}

