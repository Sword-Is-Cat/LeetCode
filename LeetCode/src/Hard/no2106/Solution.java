package Hard.no2106;

class Solution {
	public int maxTotalFruits(int[][] fruits, int startPos, int k) {

		int leftFruits = 0, rightFruits = 0, left = -1, right = -1;
		for (int i = 0; i < fruits.length; i++) {

			if (fruits[i][0] <= startPos && startPos - fruits[i][0] <= k) {
				if (left == -1)
					left = i;
				leftFruits += fruits[i][1];
			}

			if (startPos <= fruits[i][0] && fruits[i][0] - startPos <= k) {
				if (right == -1)
					right = i;
				rightFruits += fruits[i][1];
			}

			if (i > 0)
				fruits[i][1] += fruits[i - 1][1];

		}

		int answer = Math.max(leftFruits, rightFruits);
		if (left == -1 || right == -1)
			return answer;

		while (left < fruits.length && right < fruits.length && fruits[left][0] < startPos) {
			int lLength = startPos - fruits[left][0], rLength = fruits[right][0] - startPos;
			if (Math.min(lLength, rLength) + lLength + rLength <= k) {
				answer = Math.max(answer, fruits[right][1] - (left == 0 ? 0 : fruits[left - 1][1]));
				right++;
			} else {
				left++;
			}
		}

		return answer;
	}
}