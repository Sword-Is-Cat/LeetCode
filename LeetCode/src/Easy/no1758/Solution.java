package Easy.no1758;

class Solution {
	public int minOperations(String s) {

		int count1 = 0, count2 = 0;

		char target = '0', mod = '0' ^ '1';

		for (char ch : s.toCharArray()) {
			if (ch == target)
				count1++;
			else
				count2++;
			target ^= mod;
		}

		return Math.min(count1, count2);

	}
}