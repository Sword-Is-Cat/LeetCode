package Medium.no1155;

import java.util.HashMap;

class Solution_ {

	HashMap<String, Integer> map = new HashMap<>();
	final int MOD = 1000000007;

	public int numRollsToTarget(int n, int k, int target) {

		if (n == 0)
			return target == 0 ? 1 : 0;

		String key = n + "/" + k + "/" + target;

		if (!map.containsKey(key)) {

			long rst = 0;

			for (int val = 1; val <= k; val++) {
				rst += numRollsToTarget(n - 1, k, target - val);
			}

			map.put(key, (int) (rst % MOD));

		}

		return map.get(key);

	}
}