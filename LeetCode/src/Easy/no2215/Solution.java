package Easy.no2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

		ArrayList<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int idx1 = 0, idx2 = 0;

		while (idx1 < nums1.length || idx2 < nums2.length) {

			int value = 0;

			if (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {

				value = nums1[idx1];

				while (idx1 < nums1.length && nums1[idx1] == value) {
					idx1++;
				}

				while (idx2 < nums2.length && nums2[idx2] == value) {
					idx2++;
				}

			} else if (idx2 == nums2.length || idx1 < nums1.length && nums1[idx1] < nums2[idx2]) {

				value = nums1[idx1];
				list.get(0).add(value);

				while (idx1 < nums1.length && nums1[idx1] == value) {
					idx1++;
				}

			} else {

				value = nums2[idx2];
				list.get(1).add(value);

				while (idx2 < nums2.length && nums2[idx2] == value) {
					idx2++;
				}

			}

		}

		return list;

	}
}