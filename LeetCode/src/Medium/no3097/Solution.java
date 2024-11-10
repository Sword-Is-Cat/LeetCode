package Medium.no3097;

class Solution {
	public int minimumSubarrayLength(int[] nums, int k) {

		int answer = Integer.MAX_VALUE;
		int[] arr = new int[31];

		for (int left = 0, right = 0; right < nums.length;) {
			addOr(arr, nums[right++]);
			while (left < right && toInt(arr) >= k) {
				answer = Math.min(answer, right - left);
				subOr(arr, nums[left++]);
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private void addOr(int[] arr, int val) {
		int i = arr.length - 1;
		while (val > 0) {
			arr[i--] += val & 1;
			val >>= 1;
		}
	}

	private void subOr(int[] arr, int val) {
		int i = arr.length - 1;
		while (val > 0) {
			arr[i--] -= val & 1;
			val >>= 1;
		}
	}

	private int toInt(int[] arr) {
		int result = 0;
		for (int num : arr) {
			result <<= 1;
			result += num > 0 ? 1 : 0;
		}
		return result;
	}
}