package Medium.no2007;

import java.util.Arrays;

class Solution {

	public int[] findOriginalArray(int[] changed) {

		int length = changed.length;
		int[] ans = new int[length / 2], era = new int[length / 2];
		int ansIdx = 0, eraIdx = 0;

		Arrays.sort(changed);
		Arrays.fill(era, -1);

		for (int num : changed) {

			if (eraIdx == length / 2) {
				return new int[0];
			} else if (num == era[eraIdx]) {
				eraIdx++;
				//System.out.println(num + " : erase");
			} else if (ansIdx == length / 2) {
				return new int[0];
			} else {
				ans[ansIdx] = num;
				era[ansIdx] = num * 2;
				ansIdx++;
				//System.out.println(num + " : input");
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().findOriginalArray(new int[] { 1, 3, 4, 2, 6, 8 });
	}

}