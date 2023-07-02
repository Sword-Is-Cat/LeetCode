package Hard.no1601;

class Solution {

	int ans = 0;

	public int maximumRequests(int n, int[][] requests) {

		int[] count = new int[n];

		dfs(count, requests, 0, 0);

		return ans;
	}

	private void dfs(int[] count, int[][] requests, int index, int move) {

		if (requests.length == index) {

			boolean isValid = true;
			for (int i = 0; isValid && i < count.length; i++) {
				isValid &= count[i] == 0;
			}

			if (isValid)
				ans = Math.max(ans, move);

		} else {

			dfs(count, requests, index + 1, move);

			count[requests[index][0]]--;
			count[requests[index][1]]++;
			dfs(count, requests, index + 1, move + 1);
			count[requests[index][0]]++;
			count[requests[index][1]]--;

		}

	}
}