package Medium.no1461;

import java.util.HashSet;

class Solution {
	public boolean hasAllCodes(String s, int k) {

		HashSet<String> set = new HashSet<>();
		for (int idx = 0; idx + k <= s.length(); idx++) {
			set.add(s.substring(idx, idx + k));
		}

		return set.size() == Math.pow(2, k);
	}
}