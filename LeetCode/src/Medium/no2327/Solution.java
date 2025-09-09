package Medium.no2327;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	public static final int MOD = 1_000_000_007;

	public int peopleAwareOfSecret(int n, int delay, int forget) {

		int day = 2, answer = 0, speakSize = forget - delay, speakSum = 0;
		Deque<Integer> delaing = new ArrayDeque<>(), speaking = new ArrayDeque<>();
		delaing.offerLast(1);

		while (day <= n) {

			if (delaing.size() == delay) {
				int speak = delaing.pollFirst();
				speakSum = (speakSum + speak) % MOD;
				speaking.offerLast(speak);
			}

			if (speaking.size() > speakSize) {
				speakSum = (MOD + speakSum - speaking.pollFirst()) % MOD;
			}

			delaing.offerLast(speakSum);

			day++;
		}

		while (!delaing.isEmpty())
			answer = (answer + delaing.pollFirst()) % MOD;

		while (!speaking.isEmpty())
			answer = (answer + speaking.pollFirst()) % MOD;

		return answer;

	}
}