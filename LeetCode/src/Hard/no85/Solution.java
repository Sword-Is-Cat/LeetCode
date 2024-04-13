package Hard.no85;

import java.util.Stack;

class Solution {
	public int maximalRectangle(char[][] matrix) {

		int answer = 0;
		int[] heights = new int[matrix[0].length];
		for (char[] floor : matrix) {
			for (int i = 0; i < floor.length; i++) {
				heights[i] = floor[i] == '0' ? 0 : (heights[i] + 1);
			}
			answer = Math.max(answer, calcLargestArea(heights));
		}

		return answer;
	}

	private int calcLargestArea(int[] heights) {

		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i <= heights.length; i++) {

			while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
				answer = Math.max(answer, width * height);
			}
			stack.add(i);

		}

		return answer;
	}
}