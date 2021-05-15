package com.example.algorithm.ya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

    @Test
    void test() {
        //Assertions.assertEquals(7, solution("23"));
        Assertions.assertEquals(11, solution("0081"));
//        Assertions.assertEquals(9, solution("022"));
    }

    public int solution(String number) {

        int length = number.length();
        int count = 0;
        for (int i = 3; i < Math.pow(10, length); i += 3) {
            if (matchCheck(number, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean matchCheck(String number, int multipleNum) {

        String temp = String.valueOf(multipleNum);
        int diffLength = number.length() - temp.length();
        if (diffLength != 0) {
            for (int i = 0; i < diffLength; i++) {
                temp = "0" + temp;
            }
        }

        int diffCount = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != temp.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return true;
    }
}
