package com.algorithm.pr.implementation.easy;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class GradingStudents {

	@Test
	void test() {
		assertThat(gradingStudents(List.of(73, 67, 38, 33))).isEqualTo(List.of(75, 67, 40, 33));
		assertThat(gradingStudents(List.of(84, 29, 57))).isEqualTo(List.of(85, 29, 57));
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {

		int size = grades.size();
		List<Integer> result = new ArrayList<>(size);

		for (Integer grade : grades) {
			int value = 0;
			int remain = 5 - grade % 5;

			if (grade < 38 || remain >= 3) {
				value = grade;
			} else {
				value = grade + remain;
			}

			// System.out.println("grade : " + grade + " - " + value);
			result.add(value);
		}

		return result;
	}

	@Test
	void test1() {
		assertThat(getMoneySpent(new int[] {40, 50, 60}, new int[] {5, 8, 12}, 60)).isEqualTo(58);
	}

	int getMoneySpent(int[] keyboards, int[] drives, int b) {

		int max = 0;

		for (Integer keyboard : keyboards) {
			for (Integer drive : drives) {

				int sum = keyboard + drive;
				if (sum > b) {
					continue;
				}

				max = Math.max(max, sum);
			}
		}

		return max;
	}

	@Test
	void test2() {
		assertThat(pickingNumbers(List.of(4,6,5,3,3,1))).isEqualTo(3);
	}


	public static int pickingNumbers(List<Integer> a) {

		List<List<Integer>> arrays = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {

			List<Integer> sub = new ArrayList<>();

			if (i + 1 == a.size()) {
				break;
			}

			for (int j = i+1; j < a.size(); j++) {
				int diff = a.get(i) - a.get(j);
				if (diff == 1 || diff == -1) {
					sub.add(a.get(i));
					sub.add(a.get(j));
				}
			}

			arrays.add(sub);
		}

		int max = 0;
		for(List<Integer> array : arrays) {
			max = Math.max(max, array.size());
		}

		return max;

	}
}
