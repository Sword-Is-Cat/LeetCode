package Easy.no905;

class Solution {
	public int[] sortArrayByParity(int[] nums) {

		int[] arr = new int[nums.length];

		int even = 0;
		int odd = arr.length - 1;

		for (int no : nums) {
			if (no % 2 == 0)
				arr[even++] = no;
			else
				arr[odd--] = no;
		}

		return arr;

	}
}