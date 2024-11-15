package Medium.no1574;

class Solution {
	public int findLengthOfShortestSubarray(int[] arr) {

		int left = 0, right = arr.length - 1;

		while (left < right && arr[left] <= arr[left + 1]) {
			left++;
		}

		while (0 < right && arr[right - 1] <= arr[right]) {
			right--;
		}

		int answer = Math.min(arr.length - left - 1, right);

		for (int i = 0; i <= left; i++) {

			while (right < arr.length && arr[i] > arr[right]) {
				right++;
			}

			answer = Math.min(answer, Math.max(0, right - i - 1));
		}

		return answer;
	}
}