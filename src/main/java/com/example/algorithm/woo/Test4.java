package com.example.algorithm.woo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test4 {

    @Test
    void test() {
//        Assertions.assertEquals(2, solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2}));
//        Assertions.assertEquals(2, solution(new int[]{1, 3, 2, 4}, new int[]{5, 6, 4, 7, 2}));
//        Assertions.assertEquals(-1, solution(new int[]{1, 3, 2, 4}, new int[]{5, 7, 8, 6, 8, 10}));
//        Assertions.assertEquals(-1, solution(new int[]{5, 7, 8, 6, 8, 10}, new int[]{1, 3, 2, 4}));
//        Assertions.assertEquals(3, solution(new int[]{1, 3, 2, 1}, new int[]{4, 3, 5, 3}));
//        Assertions.assertEquals(-1, solution(new int[]{1, 2}, new int[]{3, 3}));
//        Assertions.assertEquals(-1, solution(new int[]{1, 2}, new int[]{3}));

        Assertions.assertEquals(1, solution(new int[]{3, 2, 5, 1}, new int[]{3, 6, 7, 8, 9, 1}));
    }

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    int solution1(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (i < m - 1 && B[i] < A[k]) {
                    i += 1;
                }
                if (A[k] == B[i]) {
                    return A[k];
                }
            }
        }
        return -1;
    }
}
