package Medium.no1218;

class Solution {
	public int longestSubsequence(int[] arr, int difference) {
		int[] cnt = new int[20001];
		int ans = 0;
		for (int num : arr) {
			cnt[num + 10000] = Math.max(cnt[num + 10000],
					(-10000 <= num - difference && num - difference <= 10000 ? cnt[num + 10000 - difference] : 0) + 1);
			ans = Math.max(ans, cnt[num + 10000]);
		}
		return ans;
	}
}