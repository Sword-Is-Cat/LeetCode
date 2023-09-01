package Easy.no338;

class Solution {
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = countBit(i);
		}
		return ans;
	}

	private int countBit(int num) {
		int cnt = 0;
		while (num > 0) {
			cnt += num & 1;
			num = num >> 1;
		}
		return cnt;
	}
}