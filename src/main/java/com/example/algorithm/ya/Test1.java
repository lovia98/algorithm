package com.example.algorithm.ya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test1 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new int[]{2, 1, 3, 5, 4}));
        Assertions.assertEquals(2, solution(new int[]{2, 3, 4, 1, 5}));
        Assertions.assertEquals(3, solution(new int[]{1, 3, 4, 2, 5}));
    }

    public int solution(int[] bulbs) {

        Set<Integer> turnOn = new HashSet<>();
        int moment = 0;
        for (int number : bulbs) {
            turnOn.add(number);
            if (allTurnOn(turnOn, number)) {
                moment++;
            }
        }
        return moment;
    }

    private boolean allTurnOn(Set<Integer> turnOn, int curNum) {
        for (int i = 1; i <= curNum; i++) {
            if (!turnOn.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
