package Hard.no1675;

import java.util.PriorityQueue;

class Solution {
	public int minimumDeviation(int[] nums) {

		int min = Integer.MAX_VALUE, deviation;
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

		for (int num : nums) {
			if (num % 2 == 1)
				num *= 2;
			min = Math.min(min, num);
			que.add(num);
		}

		deviation = que.peek() - min;

		while (!que.isEmpty() && que.peek() % 2 == 0) {

			int num = que.poll() / 2;
			min = Math.min(min, num);
			que.add(num);
			deviation = Math.min(deviation, que.peek() - min);

		}

		return deviation;
	}
}