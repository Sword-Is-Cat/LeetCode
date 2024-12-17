package Medium.no2182;

class Solution {
	public String repeatLimitedString(String s, int repeatLimit) {

		int[] cnt = new int[26];
		for (char ch : s.toCharArray())
			cnt[ch - 'a']++;

		StringBuilder sb = new StringBuilder();

		for (int i = 25; i >= 0; i--) {
			if (cnt[i] <= repeatLimit) {
				while (cnt[i]-- > 0) {
					sb.append((char) ('a' + i));
				}
			} else {
				cnt[i] -= repeatLimit;
				for (int j = 0; j < repeatLimit; j++)
					sb.append((char) ('a' + i));
				int temp = i - 1;
				while (temp > -1 && cnt[temp] == 0)
					temp--;
				if (temp < 0)
					break;
				else {
					sb.append((char) ('a' + temp));
					cnt[temp]--;
				}
				i++;
			}
		}

		return sb.toString();
	}
}