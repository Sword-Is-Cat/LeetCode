package Medium.no1208;

class Solution {
	public int equalSubstring(String s, String t, int maxCost) {

		int[] dif = new int[s.length()];
		for (int i = 0; i < dif.length; i++) {
			dif[i] = Math.abs(s.charAt(i) - t.charAt(i));
		}

		int left = 0, right = 0, cost = 0, ans = 0;
		while (left < dif.length && right <= dif.length) {
			if (cost <= maxCost) {
				ans = Math.max(ans, right - left);
			}
			if (cost <= maxCost && right < dif.length) {
				cost += dif[right++];
			} else {
				cost -= dif[left++];
			}
		}

		return ans;
	}
}