package Medium.no1035;

class Solution {

	int[] nums1, nums2;
	Integer[][] cache;

	public int maxUncrossedLines(int[] nums1, int[] nums2) {

		this.nums1 = nums1;
		this.nums2 = nums2;
		cache = new Integer[nums1.length][nums2.length];

		return countLines(0, 0);

	}

	private int countLines(int idx1, int idx2) {

		if (idx1 == nums1.length || idx2 == nums2.length)
			return 0;

		if (cache[idx1][idx2] == null) {

			int rst = 0;

			if (nums1[idx1] == nums2[idx2]) {
				rst = 1 + countLines(idx1 + 1, idx2 + 1);
			} else {
				rst = Math.max(countLines(idx1 + 1, idx2), countLines(idx1, idx2 + 1));
			}

			cache[idx1][idx2] = rst;

		}

		return cache[idx1][idx2];
	}
}