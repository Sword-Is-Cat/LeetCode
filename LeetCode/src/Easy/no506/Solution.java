package Easy.no506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public String[] findRelativeRanks(int[] nums) {

		String[] answer = new String[nums.length];
		Map<Integer, String> map = pointToRankMap(nums);

		for (int i = 0; i < nums.length; i++) {
			answer[i] = map.get(nums[i]);
		}

		return answer;
	}

	private Map<Integer, String> pointToRankMap(int[] nums) {

		Map<Integer, String> map = new HashMap<>();
		int[] rank = nums.clone();
		Arrays.sort(rank);

		String[] example = { "", "Gold Medal", "Silver Medal", "Bronze Medal" };

		for (int i = 1; i <= rank.length; i++) {
			map.put(rank[rank.length - i], i < 4 ? example[i] : (i + ""));
		}

		return map;

	}
}