package Medium.no2300;

import java.util.Arrays;

class Solution {
	public int[] successfulPairs(int[] spells, int[] potions, long success) {

		Arrays.sort(potions);
		int[] answer = new int[spells.length];

		for (int i = 0; i < spells.length; i++) {
			answer[i] = calculate(spells[i], potions, success);
		}

		return answer;

	}

	private int calculate(int spellPower, int[] potions, long success) {

		int left = -1, right = potions.length;

		while (left + 1 < right) {

			int mid = (left + right) / 2;
			if (1L * spellPower * potions[mid] < success)
				left = mid;
			else
				right = mid;

		}

		return potions.length - right;
	}
}