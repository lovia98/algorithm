package com.algorithm.pr.implementation.easy;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AppleAndOranges {

	@Test
	void test() {
		countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
	}

	public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

		long aCount = apples.stream().filter(apple -> apple + a >= s && apple + a <= t).count();
		long bCount = oranges.stream().filter(orange -> orange + b >= s && orange + b <= t).count();

		System.out.println(aCount);
		System.out.println(bCount);
	}

	@Test
	void test1() {
		List<Integer> integers = breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1));

		assertThat(integers).isEqualTo(List.of(2, 4));
	}

	public static List<Integer> breakingRecords(List<Integer> scores) {

		int max = scores.get(0), min = scores.get(0);

		int minCnt = 0;
		int maxCnt = 0;

		for (int i = 1; i < scores.size(); i++) {
			if (scores.get(i) > max) {
				maxCnt++;
				max = scores.get(i);
			} else if (scores.get(i) < min) {
				minCnt++;
				min = scores.get(i);
			}
		}

		return List.of(maxCnt, minCnt);
	}

}
