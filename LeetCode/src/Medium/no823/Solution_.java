package Medium.no823;

import java.util.Arrays;
import java.util.HashMap;

class Solution_ {

	final static int MOD = (int) 1e9 + 7;

	public int numFactoredBinaryTrees(int[] arr) {

		HashMap<Integer, Long> map = new HashMap<>();
		long ans = 0;
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			long value = 1;
			int num = arr[i];

			for (int j = 0; j < i; j++) {

				int div = arr[j];

				if (num % div == 0 && map.containsKey(num / div)) {
					value += (map.get(div) * map.get(num / div)) % MOD;
				}

			}

			map.put(num, value % MOD);
			ans += map.get(num);

		}

		return (int) (ans % MOD);
	}
}