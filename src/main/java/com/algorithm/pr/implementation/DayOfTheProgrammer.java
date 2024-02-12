package com.algorithm.pr.implementation;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class DayOfTheProgrammer {
	@Test
	void test() {
		assertThat(dayOfProgrammer(1918)).isEqualTo("26.09.1918");
		assertThat(dayOfProgrammer(1800)).isEqualTo("12.09.1800");
		assertThat(dayOfProgrammer(2016)).isEqualTo("12.09.2016");
		assertThat(dayOfProgrammer(1984)).isEqualTo("12.09.1984");
		assertThat(dayOfProgrammer(2017)).isEqualTo("13.09.2017");
	}
	public static String dayOfProgrammer(int year) {

		int remainDays = 256;
		int[] days = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		boolean julian = year <= 1918;
		boolean isLeapYear = julian && year % 4 == 0 || !julian && (year % 400 == 0 || (year % 4 == 0 && year % 100 > 0));

		days[1] = isLeapYear? 29 : 28;
		if (year == 1918) {
			days[1] -= 13;
		}

		int month = 0;
		for (int i = 0; i < days.length; i++) {

			if (remainDays <= days[i]) {
				break;
			}

			remainDays -= days[i];
			month = i+1;
		}

		if (remainDays > 0) {
			month++;
		}

		final String strDay = remainDays > 9 ? ""+remainDays : "0"+month;
		final String strMonth = month > 9 ? ""+month : "0"+month;

		return String.format("%s.%s.%s", strDay, strMonth, year);
	}

	@Test
	void test1() {
		bonAppetit(List.of(2, 4, 6), 2, 3);
		bonAppetit(List.of(3, 10, 2, 9), 1, 12);
	}

	public static void bonAppetit(List<Integer> bill, int k, int b) {

		int share = 0;

		for (int i = 0; i < bill.size(); i++) {
			if (i != k) {
				share += bill.get(i);
			}
		}

		int divid = share / 2;
		if (divid == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - divid);
		}
	}

	@Test
	void test2() {
		assertThat(sockMerchant(7, List.of(1, 2, 1, 2, 1 , 3, 2))).isEqualTo(2);
		assertThat(sockMerchant(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20))).isEqualTo(3);
	}
	public static int sockMerchant(int n, List<Integer> ar) {

		Map<Integer, Integer> pair = new HashMap<>();
		for (Integer a : ar) {
			int count = pair.getOrDefault(a, 0);
			pair.put(a, count + 1);
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : pair.entrySet()) {
			count += entry.getValue() / 2;
		}

		return count;
	}
}
