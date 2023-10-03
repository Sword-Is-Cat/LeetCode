package Easy.no1512;

class Solution {
	public int numIdenticalPairs(int[] nums) {

		int[] cnts = new int[101];
		int ans = 0;

		for (int num : nums)
			cnts[num]++;

		for (int cnt : cnts)
			ans += calc(cnt);

		return ans;
	}

	private int calc(int n) {
		return n * (n - 1) / 2;
	}
}