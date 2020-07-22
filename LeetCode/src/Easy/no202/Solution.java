package Easy.no202;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean isHappy(int n) {

		Set<Integer> set = new HashSet<>();

		while (n > 1) {

			if (!set.add(n))
				return false;

			int m = 0;

			while (n > 0) {

				m += Math.pow(n % 10, 2);
				n /= 10;
			}

			n = m;

		}

		return true;

	}
}