package Medium.no718;

class Solution {
	public int findLength(int[] nums1, int[] nums2) {

		int length = 0, temp = 0;

		for (int gap = 1 - nums1.length; gap < nums2.length; gap++) {

			int st = Math.max(0, gap), ed = Math.min(nums1.length + gap, nums2.length);

			temp = 0;

			for (int idx = st; idx < ed; idx++) {

				if (nums1[idx - gap] == nums2[idx])
					length = Math.max(length, ++temp);
				else
					temp = 0;

			}

		}

		return length;
	}
}