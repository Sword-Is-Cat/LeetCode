package Hard.no2040;

class Solution {

	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {

		int length1 = nums1.length;
		long left = -10000000000L, right = 10000000000L;

		while (left <= right) {

			long mid = (left + right) / 2;
			long count = 0;
			for (int i = 0; i < length1; i++) {
				count += f(nums2, nums1[i], mid);
			}

			if (count < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}

	int f(int[] nums2, long num1, long v) {

		int length2 = nums2.length;
		int left = 0, right = length2 - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			long prod = (long) nums2[mid] * num1;
			if ((num1 >= 0 && prod <= v) || (num1 < 0 && prod > v)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (num1 >= 0) {
			return left;
		} else {
			return length2 - left;
		}
	}
}