package com.example.algorithm.questions.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class Spy {

    @Test
    public void test() {
        Assertions.assertEquals(5, solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
        Assertions.assertEquals(3, solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}}));
        Assertions.assertEquals(11, solution(new String[][]{{"bluesunglasses", "face"}, {"redsunglasses", "face"},
                {"longcut", "pants"}, {"green_truban", "headgear"}}));

        Assertions.assertEquals(7, solution(new String[][]{{"bluesunglasses", "face"},
                {"longcut", "pants"}, {"green_truban", "headgear"}}));

        //1개씩 만 착용 -> 3 / 3개 모두 착용 -> 1 / 2개 착용 -> face, pants / pants, headgear / face, headgear

    }

    /**
     * headgear :2 , eyewear : 1 --> 2가지를 조합해서 입을 경우 (2*1) + 한가지만 입을 경우의 수 (3) --> 5
     *
     * face : 3 --> 1가지씩만 입을 수 있는 경우의 수 3
     * face : 2, pants : 1, headgear : 1 --> 3가지를 입을 있는 경우 (2 * 1 * 1)
     * + face,pants 를 입는 경우 수 (2 * 1) + face, headgear 를 입는 경우 (2 * 1) + pants, headgear (1 * 1)
     * + 한 아이템만 입는 경우 수 : 4
     * = 2 + 5 + 4 = 11
     *
     *
     *
     * @param clothes
     * @return
     */
    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String kind = clothe[1];

            if (clothesMap.containsKey(kind)) {
                clothesMap.put(kind, clothesMap.get(kind) + 1);
            } else {
                clothesMap.put(kind, 1);
            }
        }

        int answer = 1;
        for (String kind : clothesMap.keySet()) {
            answer *= (clothesMap.get(kind) + 1);
        }

        return answer - 1;
    }
}
