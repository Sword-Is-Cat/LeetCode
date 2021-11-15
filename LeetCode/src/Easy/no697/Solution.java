package Easy.no697;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int findShortestSubArray(int[] nums) {

		Map<Integer, Integer> noCnt = new HashMap<>();

		for (int no : nums)
			if (noCnt.containsKey(no))
				noCnt.put(no, noCnt.get(no) + 1);
			else
				noCnt.put(no, 1);

		int maxFreq = 0;
		Set<Integer> set = new HashSet<>();

		for (int key : noCnt.keySet()) {

			int cnt = noCnt.get(key);

			if (maxFreq < cnt) {
				maxFreq = cnt;
				set.clear();
				set.add(key);
			} else if (maxFreq == cnt) {
				set.add(key);
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int freqKey : set) {

			int firstIndex = -1;
			int lastIndex = -1;

			for (int i = 0; i < nums.length; i++) {

				if (nums[i] == freqKey) {
					if (firstIndex == -1)
						firstIndex = i;
					lastIndex = i;
				}
			}
			answer = Math.min(answer, lastIndex - firstIndex + 1);
		}
		return answer;
	}
}