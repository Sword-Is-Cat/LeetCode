package Medium.no3186;

import java.util.TreeMap;

class Solution {
	public long maximumTotalDamage(int[] power) {

		TreeMap<Integer, Integer> counter = new TreeMap<>();
		for (int pow : power)
			counter.put(pow, counter.getOrDefault(pow, 0) + 1);

		int[][] data = new int[counter.size()][];
		int idx = 0;
		for (int pow : counter.keySet())
			data[idx++] = new int[] { pow, counter.get(pow) };

		long temp = 0, answer = 0;
		long[] cache = new long[data.length];
		for (int cur = 0, pre = 0; cur < data.length; cur++) {

			while (pre < cur && data[pre][0] < data[cur][0] - 2)
				temp = Math.max(temp, cache[pre++]);

			cache[cur] = temp + 1L * data[cur][0] * data[cur][1];
			answer = Math.max(answer, cache[cur]);

		}

		return answer;
	}
}