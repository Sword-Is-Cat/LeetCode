package Easy.no414;

class Solution {
	public int thirdMax(int[] nums) {

		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for (int i : nums) {

			if (max1 == null)
				max1 = i;
			else if (max2 == null) {
				if (i == max1)
					continue;
				max2 = Math.min(max1, i);
				max1 = Math.max(max1, i);
			} else if (max3 == null) {
				if (i == max1 || i == max2)
					continue;
				int sum = max1 + max2 + i;
				max1 = Math.max(max1, i);
				max3 = Math.min(max2, i);
				max2 = sum - max1 - max3;
			} else if (i == max1 || i == max2 || i == max3)
				continue;
			else if (i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (i > max2) {
				max3 = max2;
				max2 = i;
			} else if (i > max3)
				max3 = i;

		}
		
		return max3 == null ? max1 : max3;
	}
}