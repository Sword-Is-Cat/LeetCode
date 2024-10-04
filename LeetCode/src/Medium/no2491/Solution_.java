package Medium.no2491;

import java.util.Arrays;

class Solution_ {
	public long dividePlayers(int[] skill) {

		Arrays.sort(skill);
		int length = skill.length, sum = skill[0] + skill[length - 1];
		long ans = 0L;

		for (int i = 0; i < length / 2; i++) {
			if (skill[i] + skill[length - 1 - i] != sum)
				return -1L;
			ans += skill[i] * skill[length - 1 - i];
		}

		return ans;
	}
}