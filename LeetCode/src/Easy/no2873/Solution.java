package Easy.no2873;

class Solution {
	public long maximumTripletValue(int[] nums) {
		long max1 = 0, max2 = 0, max3 = 0;
		for (int num : nums) {
			max3 = Math.max(max3, max2 * num);
			max2 = Math.max(max2, max1 - num);
			max1 = Math.max(max1, num);
		}
		return max3;
	}
}