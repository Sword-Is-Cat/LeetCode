package Medium.no473;

import java.util.Arrays;

class Solution {
	public boolean makesquare(int[] matchsticks) {

		int target = 0;
		for (int stickLeng : matchsticks)
			target += stickLeng;

		if (target % 4 != 0)
			return false;

		target /= 4;

		Arrays.sort(matchsticks);
		int[] matchs = new int[matchsticks.length];

		for (int i = 0; i < matchs.length; i++)
			matchs[i] = matchsticks[matchs.length - 1 - i];

		return process(matchs, 0, target, 0, 0, 0, 0);
	}

	boolean process(int[] matchs, int idx, int target, int no1, int no2, int no3, int no4) {

		if (idx == matchs.length)
			return no1 == target && no2 == target && no3 == target && no4 == target;

		boolean result = false;

		int value = matchs[idx++];

		if (!result && target >= no1 + value)
			result |= process(matchs, idx, target, no1 + value, no2, no3, no4);

		if (!result && target >= no2 + value)
			result |= process(matchs, idx, target, no1, no2 + value, no3, no4);

		if (!result && target >= no3 + value)
			result |= process(matchs, idx, target, no1, no2, no3 + value, no4);

		if (!result && target >= no4 + value)
			result |= process(matchs, idx, target, no1, no2, no3, no4 + value);

		return result;
	}
}