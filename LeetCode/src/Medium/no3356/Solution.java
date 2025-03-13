package Medium.no3356;

class Solution {
	public int minZeroArray(int[] nums, int[][] queries) {

		int qi = 0, change = 0;
		int[] changes = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			change += changes[i];
			while (change < nums[i] && qi < queries.length) {
				int[] query = queries[qi++];
				changes[query[0]] += query[2];
				changes[query[1] + 1] -= query[2];
				if (query[0] <= i && i <= query[1]) {
					change += query[2];
				}
			}
			if (change < nums[i] && qi == queries.length)
				return -1;

		}

		return qi;
	}
}