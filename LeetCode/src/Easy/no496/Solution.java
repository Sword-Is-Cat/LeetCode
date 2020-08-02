package Easy.no496;

class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] answer = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {

			int result = -1;
			boolean flag = false;

			for (int j = 0; j < nums2.length; j++) {

				if (nums1[i] == nums2[j]) {
					flag = true;
				} else if (flag && nums1[i] < nums2[j]) {
					result = nums2[j];
					break;
				}
			}

			answer[i] = result;
		}

		return answer;

	}
}