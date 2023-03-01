package Medium.no912;

class Solution {
	public int[] sortArray(int[] nums) {

		divide(nums, 0, nums.length);

		return nums;
	}

	protected void divide(int[] arr, int left, int right) {

		if (left + 1 == right)
			return;

		int mid = (left + right) / 2;

		divide(arr, left, mid);
		divide(arr, mid, right);
		merge(arr, left, right);

	}

	protected void merge(int[] arr, int left, int right) {

		int mid = (left + right) / 2;
		int length1 = mid - left, length2 = right - mid;

		int[] arr1 = new int[length1], arr2 = new int[length2];

		for (int idx = left, i1 = 0, i2 = 0; idx < right; idx++) {
			if (i1 < length1)
				arr1[i1++] = arr[idx];
			else
				arr2[i2++] = arr[idx];
		}

		for (int idx = left, i1 = 0, i2 = 0; idx < right; idx++) {
			if (i2 == length2 || i1 < length1 && arr1[i1] < arr2[i2])
				arr[idx] = arr1[i1++];
			else
				arr[idx] = arr2[i2++];
		}
	}
}
