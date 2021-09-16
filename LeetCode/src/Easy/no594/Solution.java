package Easy.no594;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int findLHS(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : nums) {
			if(map.containsKey(num))
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		
		int answer = 0;
		
		for(int key : map.keySet()) {
			if(map.containsKey(key+1))
				answer = Math.max(answer, map.get(key)+map.get(key+1));
		}
		
		return answer;

	}
}