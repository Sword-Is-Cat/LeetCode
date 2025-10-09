package Medium.no3494;

class Solution {
	public long minTime(int[] skill, int[] mana) {

		int sLen = skill.length, mLen = mana.length;
		long[][] table = new long[mLen + 1][sLen + 1];

		for (int m = 1; m <= mLen; m++) {
			for (int s = 1; s <= sLen; s++) {
				long startTime = Math.max(table[m - 1][s], table[m][s - 1]);
				table[m][s] = startTime + skill[s - 1] * mana[m - 1];
			}
			for (int s = sLen - 1; s > 0; s--) {
				table[m][s] = table[m][s + 1] - skill[s] * mana[m - 1];
			}
		}

		return table[mLen][sLen];
	}
}