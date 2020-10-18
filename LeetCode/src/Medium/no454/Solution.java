package Medium.no454;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : A)
			for (int j : B) {
				if(map.containsKey(i+j))
					map.replace(i+j, map.get(i+j)+1);
				else
					map.put(i+j, 1);
			}

		for (int k : C)
			for (int l : D) {
				if(map.containsKey(-k-l))
					answer+=map.get(-k-l);
			}

		return answer;
	}
}