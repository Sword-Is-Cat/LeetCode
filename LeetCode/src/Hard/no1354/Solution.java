package Hard.no1354;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
	public boolean isPossible(int[] target) {

		if (target.length == 1)
			return target[0] == 1;

		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

		int sum = 0;
		int length = target.length;

		HashSet<Integer> dupl = new HashSet<>();

		for (int num : target) {

			if ((num - 1) % (length - 1) != 0)
				return false;

			if (num != 1 && !dupl.add(num))
				return false;

			num = (num - 1) / (length - 1);
			que.add(num);
			sum += num;
		}

		while (que.peek() > 0) {

			int num = que.poll();

			System.out.println("sum:" + sum + ", num:" + num);

			sum -= num;
			if (sum == 0)
				return true;
			if (sum == num)
				return false;
			num %= sum + 1;
			sum += num;

			que.add(num);
		}
		return false;
	}
}