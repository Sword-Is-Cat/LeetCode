package Medium.no3011;

class Solution {
	public boolean canSortArray(int[] nums) {

		int[] bit = nums.clone();
		for (int i = 0; i < bit.length; i++) {
			bit[i] = Integer.bitCount(bit[i]);
		}

		int end = nums.length;
		while (end-- > 0) {
			for (int i = 0; i < end; i++) {
				if (nums[i] > nums[i + 1]) {
					if (bit[i] != bit[i + 1])
						return false;
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}
		}

		return true;
	}
}