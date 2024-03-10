package Easy.no349;

import java.util.ArrayList;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {

		boolean[][] nums = new boolean[1001][2];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			nums[nums1[i]][0] = true;
		}

		for (int i = 0; i < nums2.length; i++) {
			if (nums[nums2[i]][0] && !nums[nums2[i]][1])
				list.add(nums2[i]);
			nums[nums2[i]][1] = true;
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}