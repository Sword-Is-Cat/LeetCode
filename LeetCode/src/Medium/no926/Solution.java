package Medium.no926;

class Solution {

	public int minFlipsMonoIncr(String s) {

		char[] arr = s.toCharArray();
		int length = arr.length;
		int[] cntOne = new int[length + 1];

		for (int i = 1; i <= length; i++) {
			cntOne[i] = cntOne[i - 1];
			if (arr[i - 1] == '1')
				cntOne[i]++;
		}

		int allOne = cntOne[length], ans = length;

		for (int i = 0; i <= length; i++) {
			ans = Math.min(ans, 2 * cntOne[i] + length - i - allOne);
		}

		return ans;
	}
}