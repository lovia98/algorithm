package com.algorithm.pr.implementation;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubArrayDivision {

	@Test
	void test() {
		Assertions.assertThat(birthday(List.of(1, 2, 1, 3, 2), 3, 2)).isEqualTo(2);
		Assertions.assertThat(birthday(List.of(4), 4, 1)).isEqualTo(1);
	}


	public static int birthday(List<Integer> s, int d, int m) {


		int count = 0;

		for (int i = 0; i < s.size(); i++) {

			int max = i + m;
			if (max > s.size()) {
				break;
			}

			int sum = 0;
			for (int j = i; j < max; j++) {
				sum += s.get(j);
			}

			if (sum == d) {
				count++;
			}

		}

		return count;
	}
}
