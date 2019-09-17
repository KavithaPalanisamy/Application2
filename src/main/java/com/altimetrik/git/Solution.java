package com.altimetrik.git;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) {

		String s1 = "E";
		String s2 = "E";

		Map<String, String> map1 = new HashMap<>();
		map1.put(s1, "Erica");
		map1.put(s2, "Bob");
		map1.put("Tie", "Tie");

		map.put('E', 1);
		map.put('M', 3);
		map.put('H', 5);

		System.out.println(map1.get(findWinner(s1, s2)));

	}

	private static String findWinner(String s1, String s2) {
		if (getScore(s1) > getScore(s2))
			return s1;
		else if (getScore(s1) < getScore(s2))
			return s2;
		else
			return "Tie";

	}

	private static int getScore(String s1) {
		int sum = 0;
		for (char c : s1.toCharArray()) {
			sum = sum + map.get((Character) c);
		}
		return sum;
	}

}
