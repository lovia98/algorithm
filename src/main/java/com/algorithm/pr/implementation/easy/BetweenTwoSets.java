package com.algorithm.pr.implementation.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 2개의 정수 arrayr가 있음. 두 조건을 따르는 모든 정수를 찾아 갯수를 return
 * 1. 첫번째 array 의 배수
 * 2. 두번째 array 의 인수
 */
public class BetweenTwoSets {

	@Test
	void test() {
		Assertions.assertEquals(2, getTotalX(new ArrayList<>(List.of(2, 6)), List.of(24, 36)));
		Assertions.assertEquals(3, getTotalX(new ArrayList<>(List.of(2, 4)), List.of(16, 32, 96)));
		Assertions.assertEquals(0, getTotalX(new ArrayList<>(List.of(100, 99, 98, 97, 96, 95, 943, 93, 92, 91)), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
		Assertions.assertEquals(9, getTotalX(new ArrayList<>(List.of(1)), List.of(100)));
		Assertions.assertEquals(8, getTotalX(new ArrayList<>(List.of(1)), List.of(72, 48)));
	}
	public static int getTotalX(List<Integer> a, List<Integer> b) {

		if (a.get(0) > b.get(0)) {
			return 0;
		}

		Integer LeastCommonMultiple = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			Integer n2 = a.get(i);
			LeastCommonMultiple = (LeastCommonMultiple * n2) / gcd(LeastCommonMultiple, n2);
		}

		int count = 0;

		for (int i = 1; LeastCommonMultiple * i <= b.get(0); i++) {
			int div = LeastCommonMultiple * i;
			boolean allDivided = b.stream().allMatch(n -> n % div == 0);

			if (allDivided) {
				count++;
			}
		}

		return count;
	}

	private static Integer gcd(Integer n1, Integer n2) {
		if (n1 % n2 == 0) {
			return n2;
		}
		return gcd(n2, n1 % n2);
	}

}
