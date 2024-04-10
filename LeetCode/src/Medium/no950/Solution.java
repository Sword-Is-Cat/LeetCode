package Medium.no950;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
	public int[] deckRevealedIncreasing(int[] deck) {

		Arrays.sort(deck);
		ArrayDeque<Integer> que = new ArrayDeque<>();

		for (int i = deck.length - 1; i >= 0; i--) {
			que.addFirst(deck[i]);
			if (i > 0) {
				que.addFirst(que.pollLast());
			}
		}

		for (int i = 0; i < deck.length; i++) {
			deck[i] = que.pollFirst();
		}

		return deck;
	}
}