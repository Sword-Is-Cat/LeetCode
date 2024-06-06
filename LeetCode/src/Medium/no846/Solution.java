package Medium.no846;

import java.util.Arrays;

class Solution {

	public boolean isNStraightHand(int[] hand, int groupSize) {

		if (hand.length % groupSize != 0)
			return false;

		Arrays.sort(hand);

		boolean answer = true;

		for (int i = 0; answer && i < hand.length; i++) {
			if (hand[i] > -1) {
				answer &= eraseStraight(hand, i, hand[i], hand[i] + groupSize);
			}
		}

		return answer;
	}

	private boolean eraseStraight(int[] hand, int idx, int value, int maxValue) {
		for (int i = idx; i < hand.length && value < maxValue; i++) {
			if (hand[i] == value) {
				hand[i] = -1;
				value++;
			}
		}
		return value == maxValue;
	}
}