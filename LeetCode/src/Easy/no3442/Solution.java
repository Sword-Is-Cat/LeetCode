package Easy.no3442;

class Solution {
	public int maxDifference(String s) {

		int[] cnts = new int[26];
		for (int i = 0; i < s.length(); i++)
			cnts[s.charAt(i) - 'a']++;

		int oddMax = 0, evenMin = 0;

		for (int cnt : cnts) {
			if (cnt == 0)
				continue;
			if (cnt % 2 == 1) {
				oddMax = Math.max(oddMax, cnt);
			} else {
				if (evenMin == 0)
					evenMin = cnt;
				evenMin = Math.min(evenMin, cnt);
			}
		}
		return oddMax - evenMin;
	}
}