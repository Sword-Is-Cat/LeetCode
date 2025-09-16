package Hard.no2197;

import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<Integer> replaceNonCoprimes(int[] nums) {

		LinkedList<Integer> answer = new LinkedList<>(), queue = new LinkedList<>();
		for (int num : nums)
			queue.offerLast(num);

		while (!queue.isEmpty()) {
			if (answer.isEmpty()) {
				answer.offerLast(queue.pollFirst());
			} else if (gcd(answer.peekLast(), queue.peekFirst()) > 1) {
				queue.offerFirst(lcm(answer.pollLast(), queue.pollFirst()));
			} else {
				answer.offerLast(queue.pollFirst());
			}
		}

		return answer;
	}

	public int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}
}