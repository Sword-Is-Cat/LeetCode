package Medium.no2411;

class Solution {
	public int[] smallestSubarrays(int[] nums) {

		int length = nums.length;
		int[] answer = new int[length];

		for (int r = 0; r < length; r++) {
			int mask = nums[r];
			answer[r] = 1;
			for (int l = r - 1; l >= 0 && (mask | nums[l]) != nums[l]; l--) {
				nums[l] |= mask;
				answer[l] = r - l + 1;
			}
		}

		return answer;
	}
}