package Medium.no2598;

class Solution {
	public int findSmallestInteger(int[] nums, int value) {

		int[] cnt = new int[value];
		for (int num : nums) {
			cnt[(num % value + value) % value]++;
		}
		
		int num = 0;
		while (true) {
			if (cnt[num % value] == 0)
				return num;
			cnt[num++ % value]--;
		}

	}
}