package Hard.no1526;

class Solution {
	public int minNumberOperations(int[] target) {
		int prev = 0, ans = 0;
		for (int num : target) {
			if (prev < num) {
				ans += num - prev;
			}
			prev = num;
		}
		return ans;
	}
}