package Hard.no834;

class Solution {
	
	int[][] conn;
	int[] cnt, ans;
	int n;

	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		this.n = n;
		this.ans = new int[n];
		this.conn = new int[n][];
		this.cnt = new int[n];

		for (int[] edge : edges) {
			cnt[edge[0]]++;
			cnt[edge[1]]++;
		}

		for (int i = 0; i < n; i++) {
			conn[i] = new int[cnt[i]];
		}

		for (int[] edge : edges) {
			conn[edge[0]][--cnt[edge[0]]] = edge[1];
			conn[edge[1]][--cnt[edge[1]]] = edge[0];
		}

		countFromRoot(0, -1);
		dfs(0, -1);

		return ans;
	}

	public void countFromRoot(int curr, int prev) {
		cnt[curr] = 1;
		for (int next : conn[curr]) {
			if (next != prev) {
				countFromRoot(next, curr);
				cnt[curr] += cnt[next];
				ans[curr] += ans[next] + cnt[next];
			}
		}
	}

	public void dfs(int curr, int prev) {
		for (int next : conn[curr]) {
			if (next != prev) {
				ans[next] = ans[curr] + n - 2 * cnt[next];
				dfs(next, curr);
			}
		}
	}
}