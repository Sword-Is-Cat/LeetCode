package Medium.no1347;

class Solution {
	public int minSteps(String s, String t) {

		int[] count1 = countSpells(s), count2 = countSpells(t);

		int ans = 0;

		for (int i = 0; i < count1.length; i++) {
			if (count1[i] > count2[i])
				ans += count1[i] - count2[i];
		}

		return ans;
	}

	private int[] countSpells(String str) {
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		return count;
	}
}