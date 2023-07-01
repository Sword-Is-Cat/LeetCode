package Medium.no2305;

class Solution {

	int ans = Integer.MAX_VALUE;

	public int distributeCookies(int[] cookies, int k) {

		int[] container = new int[k];

		dfs(cookies, container, 0);

		return ans;
	}

	private void dfs(int[] cookies, int[] container, int index) {

		if (index == cookies.length) {
			int max = 0;
			for (int val : container)
				max = Math.max(max, val);
			ans = Math.min(ans, max);
			return;
		}

		for (int i = 0; i < container.length; i++) {
			container[i] += cookies[index];
			dfs(cookies, container, index + 1);
			container[i] -= cookies[index];
			if (container[i] == 0)
				break;
		}

	}
}