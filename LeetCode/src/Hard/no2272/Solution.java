package Hard.no2272;

import java.util.HashSet;

class Solution {
	public int largestVariance(String s) {

		char[] arr = s.toCharArray();
		HashSet<Character> set = new HashSet<>();
		for (char ch : arr)
			set.add(ch);

		int ans = 0, cnt1, cnt2, run = 2;

		while (run-- > 0) {

			for (char ch1 : set) {
				for (char ch2 : set) {

					if (ch1 == ch2) {
						continue;
					}

					cnt1 = cnt2 = 0;

					for (int i = 0; i < arr.length; i++) {

						if (ch1 == arr[i])
							cnt1++;
						else if (ch2 == arr[i])
							cnt2++;

						if (cnt1 > cnt2) {
							cnt1 = cnt2 = 0;
						} else if (0 < cnt1 && 0 < cnt2) {
							ans = Math.max(ans, cnt2 - cnt1);
						}

					}
				}
			}
			arr = new StringBuilder(s).reverse().toString().toCharArray();
		}

		return ans;
	}
}