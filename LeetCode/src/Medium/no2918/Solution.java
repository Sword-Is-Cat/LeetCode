package Medium.no2918;

class Solution {
	public long minSum(int[] nums1, int[] nums2) {
		long sum1 = 0, sum2 = 0;
		boolean hasZero1 = false, hasZero2 = false;

		for (int num1 : nums1) {
			if (num1 == 0) {
				hasZero1 = true;
				num1 = 1;
			}
			sum1 += num1;
		}

		for (int num2 : nums2) {
			if (num2 == 0) {
				hasZero2 = true;
				num2 = 1;
			}
			sum2 += num2;
		}

		if (hasZero1 & hasZero2)
			return Math.max(sum1, sum2);
		if (!hasZero1 & !hasZero2)
			return sum1 == sum2 ? sum1 : -1;
		if (hasZero1)
			return sum2 < sum1 ? -1 : sum2;
		return sum1 < sum2 ? -1 : sum1;

	}
}