package Hard.no42;

class Solution {
	public int trap(int[] height) {

		int length = height.length;

		int[] leftTop = new int[length];
		int[] rightTop = new int[length];
		int[] waterTop = new int[length];

		int left = 0;
		for (int i = 0; i < length; i++) {
			left = Math.max(left, height[i]);
			leftTop[i] = left;
		}

		int right = 0;
		for (int i = length - 1; i >= 0; i--) {
			right = Math.max(right, height[i]);
			rightTop[i] = right;
		}

		for (int i = 0; i < length; i++) {
			waterTop[i] = Math.min(leftTop[i], rightTop[i]);
		}

		int result = 0;

		for (int i = 0; i < length; i++) {
			result += waterTop[i] > height[i] ? waterTop[i] - height[i] : 0;
		}
		
		return result;
	}
}