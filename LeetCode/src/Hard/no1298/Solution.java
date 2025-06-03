package Hard.no1298;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

		Queue<Integer> queue = new ArrayDeque<>();
		for (int init : initialBoxes)
			queue.offer(init);

		int answer = 0, unopen = 0;

		while (!queue.isEmpty() && unopen < queue.size()) {
			// 종료조건: 보유상자가 없거나, 보유상자 모두 열리지 않는경우
			int box = queue.poll();
			if (status[box] == 1) {
				// 열린박스인경우, unopen 카운터 초기화
				unopen = 0;
				answer += candies[box];
				for (int key : keys[box])
					status[key] = 1;
				for (int nextBox : containedBoxes[box])
					queue.offer(nextBox);
			} else {
				// 안열린박스
				unopen++;
				queue.offer(box);
			}

		}

		return answer;
	}
}