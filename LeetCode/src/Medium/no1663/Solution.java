package Medium.no1663;

class Solution {
	public String getSmallestString(int n, int k) {

		StringBuilder sb = new StringBuilder();

		k -= n;

		for (int i = 0; i < n; i++) {

			int val = k > 25 ? 25 : k;
			sb.append((char) ('a' + val));
			k -= val;
		}
		return sb.reverse().toString();
	}
}