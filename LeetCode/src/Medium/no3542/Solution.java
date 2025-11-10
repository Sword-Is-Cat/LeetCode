package Medium.no3542;

class Solution {
	public int minOperations(int[] nums) {

		int[] stack = new int[nums.length + 1];
		int ans = 0, i = 0;
		for (int num : nums) {
			while (stack[i] > num)
				i--;
			if (stack[i] < num) {
				stack[++i] = num;
				ans++;
			}
		}

		return ans;
	}
}