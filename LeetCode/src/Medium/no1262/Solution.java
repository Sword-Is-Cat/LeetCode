package Medium.no1262;

class Solution {
	public int maxSumDivThree(int[] nums) {
		int sum = 0, min1 = 40000, min2 = 40001;
		for (int num : nums) {
			sum += num;
			switch (num % 3) {
			case 1:
				min2 = Math.min(min2, min1 + num);
				min1 = Math.min(min1, num);
				break;
			case 2:
				min1 = Math.min(min1, min2 + num);
				min2 = Math.min(min2, num);
				break;
			}
		}
		if (sum % 3 == 0)
			return sum;
		return sum % 3 == 1 ? sum - min1 : sum - min2;
	}
}