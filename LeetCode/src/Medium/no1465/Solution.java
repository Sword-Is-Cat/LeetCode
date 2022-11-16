package Medium.no1465;

import java.util.Arrays;

class Solution {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		long hMax = h - horizontalCuts[horizontalCuts.length - 1];

		for (int hIdx = 0; hIdx < horizontalCuts.length; hIdx++) {
			int temp = horizontalCuts[hIdx] - (hIdx == 0 ? 0 : horizontalCuts[hIdx - 1]);
			hMax = Math.max(hMax, temp);
		}

		long wMax = w - verticalCuts[verticalCuts.length - 1];

		for (int vIdx = 0; vIdx < verticalCuts.length; vIdx++) {
			int temp = verticalCuts[vIdx] - (vIdx == 0 ? 0 : verticalCuts[vIdx - 1]);
			wMax = Math.max(wMax, temp);
		}

		return (int) ((hMax * wMax) % 1000000007);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));
	}
}