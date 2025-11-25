package Medium.no1015;

class Solution {
	public int smallestRepunitDivByK(int k) {
		if (k == 1) {
			return 1;
		}
		boolean[] visit = new boolean[k];
		int rmn = 1, ans = 1;
		while (rmn > 0) {
			if (visit[rmn]) {
				return -1;
			}
			visit[rmn] = true;
			rmn = (rmn * 10 + 1) % k;
			ans++;
		}
		return ans;

	}
}