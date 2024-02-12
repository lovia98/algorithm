package com.algorithm.pr.implementation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PageCount {

	@Test
	void test() {
		assertThat(pageCount(6, 5)).isEqualTo(1);
		assertThat(pageCount(3, 1)).isEqualTo(0);
		assertThat(pageCount(6, 4)).isEqualTo(1);
		assertThat(pageCount(5, 3)).isEqualTo(1);
		assertThat(pageCount(6, 2)).isEqualTo(1);
		assertThat(pageCount(5, 4)).isEqualTo(0);
	}

	public static int pageCount(int n, int p) {

		n = n % 2 == 0? n + 1 : n;

		int sCnt = p / 2;
		int sEnd = (n - p) / 2;

		return Math.min(sCnt, sEnd);
	}
}
