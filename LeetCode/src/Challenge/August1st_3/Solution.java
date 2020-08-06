package Challenge.August1st_3;

class Solution {
	public boolean isPowerOfFour(int num) {

		boolean answer = false;

		int root = (int) Math.sqrt(num);

		if (num != 0)
			if (root * root == num && (Integer.MAX_VALUE / 2 + 1) % root == 0)
				answer = true;

		return answer;

	}
}