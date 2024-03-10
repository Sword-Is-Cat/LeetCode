package Easy.no349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_ {
	public int[] intersection(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		Set<Integer> set = new HashSet<>();

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j])
				i++;
			else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}

		Integer[] temp = (Integer[]) set.toArray(new Integer[set.size()]);

		int[] answer = new int[temp.length];

		for (int k = 0; k < answer.length; k++)
			answer[k] = temp[k];

		return answer;
	}
}