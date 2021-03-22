package Hard.no4;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int length1 = nums1.length;
		int length2 = nums2.length;
		boolean isOdd = (length1 + length2) % 2 == 1;
		int targetIndex = (length1 + length2 - 1) / 2;

		if (length1 * length2 == 0) {

			int[] temp = length1 == 0 ? nums2 : nums1;

			return isOdd ? temp[targetIndex] * 1d : (temp[targetIndex] + temp[targetIndex + 1]) / 2d;

		} else {

			double targetNo1 = 0, targetNo2 = 0;

			int index1 = 0, index2 = 0;

			while (index1 + index2 < targetIndex) {

				if (index1 == length1) {
					index2++;
				} else if (index2 == length2) {
					index1++;
				} else {

					if (nums1[index1] < nums2[index2])
						index1++;
					else
						index2++;

				}
			}

			if (index1 == length1) {
				targetNo1 = nums2[index2++];
			} else if (index2 == length2) {
				targetNo1 = nums1[index1++];
			} else {
				targetNo1 = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
			}

			if (!isOdd) {
				if (index1 == length1) {
					targetNo2 = nums2[index2++];
				} else if (index2 == length2) {
					targetNo2 = nums1[index1++];
				} else {
					targetNo2 = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
				}
			}

			System.out.println("no1:" + targetNo1);
			System.out.println("no2:" + targetNo2);

			return isOdd ? targetNo1 : (targetNo1 + targetNo2) / 2;
		}

	}
}