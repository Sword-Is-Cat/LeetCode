package Easy.no2558;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public long pickGifts(int[] gifts, int k) {

		Queue<Integer> que = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int gift : gifts) {
			que.offer(gift);
		}

		while (k-- > 0) {
			que.offer(getRoot(que.poll()));
		}

		long answer = 0;
		while (!que.isEmpty()) {
			answer += que.poll();
		}

		return answer;
	}

	private int getRoot(int val) {

		int left = 0, right = 40000;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (mid * mid <= val)
				left = mid;
			else
				right = mid;
		}

		return left;
	}
}