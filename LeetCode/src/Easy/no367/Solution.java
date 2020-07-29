package Easy.no367;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean isPerfectSquare(int num) {

		int i = 1;
		Set<Integer> set = new HashSet<>();

		while (set.add(i)) {
			i = (i + num / i) / 2;
		}

		return i * i == num ? true : false;

	}
}