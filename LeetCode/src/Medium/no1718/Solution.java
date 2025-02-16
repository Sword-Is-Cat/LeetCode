package Medium.no1718;

class Solution {

	int[] answer;

	public int[] constructDistancedSequence(int n) {

		dfs(new int[2 * n - 1], new boolean[n + 1], 0);

		return answer;
	}

	private boolean dfs(int[] container, boolean[] used, int idx) {
		
		if(answer!=null)
			return false;

		if (idx == container.length) {
			answer = container.clone();
			return true;
		}

		if (container[idx] != 0) {
			return dfs(container, used, idx + 1);
		}

		for (int num = used.length - 1; num >= 1; num--) {
			if (!used[num]) {
				if (num == 1) {
					container[idx] = num;
					used[num] = true;
					if (dfs(container, used, idx + 1))
						return true;
					container[idx] = 0;
					used[num] = false;
				} else if (idx + num < container.length && container[idx + num] == 0) {
					container[idx] = num;
					container[idx + num] = num;
					used[num] = true;
					if (dfs(container, used, idx + 1))
						return true;
					container[idx] = 0;
					container[idx + num] = 0;
					used[num] = false;
				}
			}
		}

		return false;
	}
}