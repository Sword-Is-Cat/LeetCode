package Medium.no923;

import java.util.HashMap;
import java.util.Map;

class Solution {

	final int MOD = 1000000007;

	public int threeSumMulti(int[] arr, int target) {

		Map<Integer, Integer> cnt = new HashMap<>();

		for (int no : arr) {
			if (!cnt.containsKey(no))
				cnt.put(no, 0);
			cnt.put(no, cnt.get(no) + 1);
		}

		long result = 0;

		for (int no1 : cnt.keySet()) {

			long temp1 = cnt.get(no1);

			cnt.put(no1, cnt.get(no1) - 1);

			for (int no2 : cnt.keySet()) {

				if (no1 > no2)
					continue;

				int no2Cnt = cnt.get(no2);

				if (no2Cnt > 0) {

					long temp2 = temp1 * no2Cnt;

					cnt.put(no2, cnt.get(no2) - 1);

					int no3 = target - no1 - no2;

					if (no3 >= no2 && cnt.containsKey(no3)) {
						long temp3 = temp2 * cnt.get(no3);

						if (no1 == no2 && no2 == no3) {
							temp3 /= 6;
						} else if (no1 == no2 || no2 == no3 || no3 == no1) {
							temp3 /= 2;
						}

						// System.out.println(no1 + "/" + no2 + "/" + no3 + ":" + temp3);
						result += temp3;
						result %= MOD;
					}

					cnt.put(no2, cnt.get(no2) + 1);
				}
			}
			cnt.put(no1, cnt.get(no1) + 1);
		}
		return (int) result;
	}
}