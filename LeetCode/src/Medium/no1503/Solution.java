package Medium.no1503;

class Solution {
	public int getLastMoment(int n, int[] left, int[] right) {
		int ans = 0;
		for (int lt : left)
			ans = Math.max(ans, lt);
		for (int rt : right)
			ans = Math.max(ans, n - rt);
		return ans;
	}
}
