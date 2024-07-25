package Medium.no912;

import java.util.Arrays;

class Solution {
	public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length);
		return nums;
	}

	private void mergeSort(int[] array, int left, int right) {

		if (left + 1 == right)
			return;

		int mid = (left + right) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid, right);

		int[] arrL = Arrays.copyOfRange(array, left, mid), arrR = Arrays.copyOfRange(array, mid, right);

		for (int i = left, iL = 0, iR = 0; i < right; i++) {
			if (iL == mid - left) {
				array[i] = arrR[iR++];
			} else if (iR == right - mid) {
				array[i] = arrL[iL++];
			} else if (arrL[iL] < arrR[iR]) {
				array[i] = arrL[iL++];
			} else {
				array[i] = arrR[iR++];
			}
		}

	}
}