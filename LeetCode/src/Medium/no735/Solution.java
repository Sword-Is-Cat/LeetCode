package Medium.no735;

import java.util.ArrayDeque;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {

		ArrayDeque<Integer> que = new ArrayDeque<>();

		for (int i = 0; i < asteroids.length;) {

			int asteroid = asteroids[i];

			if (!que.isEmpty() && que.peekLast() > 0 && asteroid < 0) {
				// 폭파
				int sum = que.peekLast() + asteroid;
				if (sum == 0) {
					// 둘다터짐
					que.pollLast();
					i++;
				} else if (sum > 0) {
					// 역행만터짐
					i++;
				} else if (sum < 0) {
					// 순행만터짐
					que.pollLast();
				}
			} else {
				// 비폭파
				que.addLast(asteroids[i++]);
			}

		}

		return que.stream().mapToInt(i -> i).toArray();
	}
}