package com.example.algorithm.woo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test3 {

    @Test
    void test() {
//        Assertions.assertEquals(3, solution(new int[] {3,2,-2,5, -3}));

        solution(new int[]{3, 2, -2, 5, -3});
    }

    public int solution(int[] numbers) {

        if (numbers.length == 0) {
            return 0;
        }

        int[] clone = numbers.clone();
        Arrays.sort(clone);
        int max = clone[clone.length - 1];
        int positive = 0, negative = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == max) {
                positive = i;
                negative = i * -1;
                break;
            }
        }

        int startIdx = 0, endIdx = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == positive) {
                System.out.print(numbers[i] + ",");
                startIdx = i;
            } else if (numbers[i] == negative) {
                endIdx = i;
                System.out.print(numbers[i] + ",");
            }
        }

        return 0;

        // write your code in Java SE 8
    }
}
