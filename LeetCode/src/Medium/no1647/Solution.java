package Medium.no1647;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int minDeletions(String s) {

		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
		}

		int delete = 0;
		Set<Integer> set = new HashSet<>();

		for (int cnt : counts) {

			while (cnt > 0 && set.contains(cnt)) {
				cnt--;
				delete++;
			}
			if (cnt > 0)
				set.add(cnt);

		}

		return delete;
	}
}