package Challenge.September2nd_3;

class Solution {
	public int maxProduct(int[] nums) {

		int temp = 1;
		int first = 0;
		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			
			answer = Math.max(answer, nums[i]);

			if (nums[i] == 0) {

				temp = 1;
				first = 0;

			} else {
				temp *= nums[i];

				if (temp < 0)
					if (first == 0)
						first = temp;
					else
						answer = Math.max(answer, temp / first);

				else
					answer = Math.max(answer, temp);
			}
		}
		return answer;
	}
}