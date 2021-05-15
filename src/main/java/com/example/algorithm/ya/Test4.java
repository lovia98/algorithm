package com.example.algorithm.ya;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test4 {

    private int solution(int Z, int[] A, int[] B) {
        /**
         * 2, 1
         * 2, 3
         * 1, 4
         * 2, 4
         *
         * 2a + 3b + 1c + 2d
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            extracted(A, countMap, i);
            extracted(B, countMap, i);
        }
        System.out.println(countMap);

        List<Integer> list = new ArrayList<>();

        for (Integer circle : countMap.keySet()) {
            list.add(countMap.get(circle));
        }

        list = list.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(list);

        Map<Integer, Integer> valMap = new HashMap<>();

        List<Integer> duplCheck = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == list.get(i) && !duplCheck.contains(entry.getKey())) {
                    valMap.put(entry.getKey(), Z - i);
                    duplCheck.add(entry.getKey());
                    break;
                }
            }
        }
        System.out.println(valMap);

        AtomicInteger result = new AtomicInteger();
        countMap.forEach((circle, count) -> {
            result.addAndGet(count * valMap.get(circle));
        });

        return result.get();
    }

    private void extracted(int[] A, Map<Integer, Integer> countMap, int i) {
        if (countMap.get(A[i]) == null) {
            countMap.put(A[i], 1);
        } else {
            countMap.put(A[i], countMap.get(A[i]) + 1);
        }
    }
}
