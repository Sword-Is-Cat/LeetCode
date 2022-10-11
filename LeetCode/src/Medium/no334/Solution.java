package Medium.no334;

class Solution {
	public boolean increasingTriplet(int[] nums) {

		int no1 = Integer.MAX_VALUE, no2 = Integer.MAX_VALUE;

		for (int num : nums) {

			if (num > no2)
				return true;

			if (num > no1)
				no2 = Math.min(num, no2);

			no1 = Math.min(num, no1);
		}

		return false;
	}
}