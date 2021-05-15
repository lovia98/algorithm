package com.example.algorithm.ya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

    @Test
    void test() {
        Assertions.assertEquals("aabaacaa", solution(6, 1, 1));
        Assertions.assertEquals("bbabc", solution(1, 3, 1));
        Assertions.assertEquals("ccbcc", solution(0, 1, 8));
    }

    public String solution(int A, int B, int C) {

        int length = A + B + C;
        String appendStr = "";

        Map<String, Integer> map = new HashMap<>();
        map.put("a", A);
        map.put("b", B);
        map.put("c", C);

        int appendCount = 0;
        String appendChar = "";
        for (int i = 0; i < length; i++) {

            String charOfMax = getCharOfMax(map, appendChar, appendCount);

            if (charOfMax == null) {
                break;
            }

            if (!appendChar.equals(charOfMax)) {
                appendCount = 0;
            }

            appendStr += charOfMax;
            appendCount++;
            appendChar = charOfMax;

            Integer curCount = map.get(charOfMax);
            if (curCount != null) {
                map.put(charOfMax, --curCount);
            }
        }

        return appendStr;
    }

    private String getCharOfMax(Map<String, Integer> map, String appendChar, int appendCount) {

        int max = 0;
        String maxChar = null;

        for (String key : map.keySet()) {
            int count = map.getOrDefault(key, 0);
            if ((appendCount == 2 && key.equals(appendChar)) || count == 0) {
                continue;
            }

            if (count > max) {
                max = count;
                maxChar = key;
            }
        }

        return maxChar;

    }
}
