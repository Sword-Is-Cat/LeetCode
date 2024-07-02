package Easy.no350;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if (nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j])
				i++;
			else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}