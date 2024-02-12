package com.algorithm.pr.implementation;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DivisibleSumPairsTest {

	@Test
	void test() {
		assertThat(divisibleSumPairs(6, 5, List.of(1, 2, 3, 4, 5, 6))).isEqualTo(3);
		assertThat(divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2))).isEqualTo(5);
	}

	public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

		int count = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (correctPair(ar.get(i), ar.get(j), k)) {
					// System.out.printf("%d, %d%n", ar.get(i), ar.get(j));
					count++;
				}
			}

		}

		return count;
	}

	private static boolean correctPair(Integer a, Integer b, int k) {
		return (a + b) % k == 0;
	}

	@Test
	void test1() {
		assertThat(migratoryBirds(List.of(1, 1, 2, 2, 3))).isEqualTo(1);
		assertThat(migratoryBirds(List.of(1, 4, 4, 4, 5, 3))).isEqualTo(4);
		assertThat(migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4))).isEqualTo(3);
	}

	public static int migratoryBirds(List<Integer> arr) {

		Map<Integer, Integer> typeCount = new HashMap<>();

		for (Integer num : arr) {
			Integer count = typeCount.getOrDefault(num, 0);
			typeCount.put(num, count+1);
		}

		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(typeCount.entrySet());
		entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

		Map.Entry<Integer, Integer> maxFreq = entryList.get(0);

		int MaxReqMinId = maxFreq.getKey();

		for (int i = 1; i <  entryList.size(); i++) {
			Map.Entry<Integer, Integer> curr = entryList.get(i);
			if (maxFreq.getValue() > curr.getValue()) {
			   break;
			}

			if (maxFreq.getKey() > curr.getKey()) {
				MaxReqMinId = curr.getKey();
			}
		}

		return MaxReqMinId;
	}
}
