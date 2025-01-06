package Medium.no1769;

class Solution {
	public int[] minOperations(String boxes) {

		int[] ans = new int[boxes.length()];
		int move, ball;

		move = ball = 0;

		for (int i = 0; i < boxes.length(); i++) {
			ans[i] += move += ball;
			ball += boxes.charAt(i) - '0';
		}
		move = ball = 0;
		for (int i = boxes.length() - 1; i >= 0; i--) {
			ans[i] += move += ball;
			ball += boxes.charAt(i) - '0';
		}

		return ans;
	}
}