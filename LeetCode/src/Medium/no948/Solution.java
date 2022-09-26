package Medium.no948;

import java.util.Arrays;

class Solution {
	public int bagOfTokensScore(int[] tokens, int power) {

		Arrays.sort(tokens);

		int score = 0, left = 0, right = tokens.length - 1;

		while (left <= right && tokens[left] <= power) {

			score++;
			power -= tokens[left++];

			if (left < tokens.length && power < tokens[left] && left < right) {
				score--;
				power += tokens[right--];
			}

		}

		return score;
	}
}