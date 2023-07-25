package Medium.no852;

class Solution {
	public int peakIndexInMountainArray(int[] arr) {

		int left = 0, right = arr.length - 1;

		while (left + 1 < right) {

			int mid = (left + right) / 2;

			if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				left = mid;
			} else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
				right = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}
}