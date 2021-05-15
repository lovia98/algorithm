package com.example.algorithm.woo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test1 {

    @Test
    void contextLoads() {
        System.out.println(solution(3, 2, new int[]{2, 1, 1, 0, 1}));
        System.out.println(solution(2, 3, new int[]{0, 0, 1, 1, 2}));
        System.out.println(solution(2, 2, new int[]{2, 0, 2, 0}));
    }

    public String solution(int U, int L, int[] C) {

        int sum = Arrays.stream(C).sum();

        if (sum != U + L) {
            return "IMPOSSIBLE";
        }

        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        boolean beforeUpper = false;

        for (int i = 0; i < C.length; i++) {
            int K = C[i];

            if (K == 2) {
                appendOne(upper);
                appendOne(lower);
                U -= 1;
                L -= 1;

            } else if (K == 1) {
                if (U > 0 && !beforeUpper) {
                    beforeUpper = true;
                    U -= 1;
                    appendOne(upper);
                    appendZero(lower);
                } else {
                    beforeUpper = false;
                    L -= 1;
                    appendZero(upper);
                    appendOne(lower);
                }

            } else {
                appendZero(upper);
                appendZero(lower);
            }
        }
        return upper.toString() + "," + lower.toString();
    }

    private StringBuilder appendZero(StringBuilder row) {
        return row.append("0");
    }

    private StringBuilder appendOne(StringBuilder row) {
        return row.append("1");
    }
}
