package Hard.no2163;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public long minimumDifference(int[] nums) {

		int length = nums.length / 3;
		long[][] sums = new long[2][length + 1];

		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		long sum = 0L;

		for (int i = 0; i < length; i++) {
			sum += nums[i];
			queue.offer(nums[i]);
		}
		sums[0][0] = sum;

		for (int i = 0; i < length; i++) {
			queue.offer(nums[length + i]);
			sum -= queue.poll();
			sum += nums[length + i];
			sums[0][i + 1] = sum;
		}

		queue = new PriorityQueue<>();
		sum = 0L;

		for (int i = length - 1; i >= 0; i--) {
			sum += nums[length * 2 + i];
			queue.offer(nums[length * 2 + i]);
		}
		sums[1][length] = sum;

		for (int i = length - 1; i >= 0; i--) {
			queue.offer(nums[length + i]);
			sum -= queue.poll();
			sum += nums[length + i];
			sums[1][i] = sum;
		}

		long answer = Long.MAX_VALUE;
		for (int i = 0; i <= length; i++) {
			answer = Math.min(answer, sums[0][i] - sums[1][i]);
		}
		
		return answer;

	}
}