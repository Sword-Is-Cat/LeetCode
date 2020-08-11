package Easy.no633;

class Solution {
	public boolean judgeSquareSum(int c) {

		int root = (int) Math.sqrt(c);
		boolean answer = false;

		for (int i = 0; i <= root; i++) {
			if (answer)
				break;
			else if (isSquare(c - i * i))
				answer = true;
		}

		return answer;
	}

	boolean isSquare(int i) {
		int temp = (int) Math.sqrt(i);
		return temp * temp == i;
	}
}