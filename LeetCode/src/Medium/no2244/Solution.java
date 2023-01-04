package Medium.no2244;

import java.util.HashMap;

class Solution {
	public int minimumRounds(int[] tasks) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int task : tasks)
			counter.compute(task, (k, v) -> v == null ? 1 : v + 1);

		int ans = 0;

		for (int key : counter.keySet()) {
			int rst = process(counter.get(key));
			if (rst == -1)
				return -1;
			ans += rst;
		}

		return ans;
	}

	int process(int cnt) {
		if (cnt == 1)
			return -1;
		return (cnt + 2) / 3;
	}
}