package Medium.no967;

import java.util.HashSet;

class Solution {
	public int[] numsSameConsecDiff(int n, int k) {

		int min = (int) Math.pow(10, n - 1);
		int max = (int) Math.pow(10, n);

		HashSet<Integer> set = new HashSet<>();

		for (int i = 1; i < 10; i++)
			process(set, min, max, k, i, i);

		int[] ans = new int[set.size()];
		int idx = 0;

		for (int num : set)
			ans[idx++] = num;

		return ans;
	}

	void process(HashSet<Integer> list, int min, int max, int k, int value, int prev) {

		if (value >= max)
			return;

		else if (value < min) {

			if (prev - k >= 0)
				process(list, min, max, k, value * 10 + prev - k, prev - k);

			if (prev + k < 10)
				process(list, min, max, k, value * 10 + prev + k, prev + k);

		} else {
			list.add(value);
		}

	}
}