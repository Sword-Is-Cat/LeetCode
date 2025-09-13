package Easy.no3541;

class Solution {
	public int maxFreqSum(String s) {

		int[] cnt = new int[26];
		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}

		int maxVoCnt = 0, maxCoCnt = 0;

		for (int i = 0; i < cnt.length; i++) {
			switch (i) {
			case 0:
			case 4:
			case 8:
			case 14:
			case 20:
				maxVoCnt = Math.max(maxVoCnt, cnt[i]);
				break;
			default:
				maxCoCnt = Math.max(maxCoCnt, cnt[i]);

			}
		}

		return maxVoCnt + maxCoCnt;
	}
}