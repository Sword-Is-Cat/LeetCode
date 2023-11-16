package Medium.no1980;

import java.util.Arrays;

class Solution {
	public String findDifferentBinaryString(String[] nums) {

		int length = nums.length;
		int[] numbers = new int[length];

		for (int i = 0; i < length; i++)
			numbers[i] = parseBinaryString(nums[i]);

		Arrays.sort(numbers);

		int answer = length;

		for (int i = 0; i < length; i++) {
			if (numbers[i] != i) {
				answer = i;
				break;
			}
		}

		return Integer.toBinaryString(answer + (1 << length)).substring(1);
	}

	private int parseBinaryString(String str) {

		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			result *= 2;
			result += str.charAt(i) - '0';
		}

		return result;
	}

}