package Medium.no826;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		PriorityQueue<int[]> projects = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		Arrays.sort(worker);

		for (int i = 0; i < difficulty.length; i++) {
			projects.add(new int[] { difficulty[i], profit[i] });
		}

		int ans = 0, prof = 0;

		for (int work : worker) {
			while (!projects.isEmpty() && projects.peek()[0] <= work) {
				prof = Math.max(prof, projects.poll()[1]);
			}
			ans += prof;
		}

		return ans;
	}
}