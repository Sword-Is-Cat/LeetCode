package Medium.no791;

class Solution {
	public String customSortString(String order, String s) {

		int[] cnt = new int[26];

		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();

		for (char ch : order.toCharArray()) {
			while (cnt[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i]-- > 0) {
				sb.append((char) ('a' + i));
			}
		}

		return sb.toString();
	}
}