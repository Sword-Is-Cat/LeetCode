package Medium.no3362;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int maxRemoval(int[] nums, int[][] queries) {

		Queue<int[]> allQueries = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		Queue<int[]> usableQueries = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		int[] expire = new int[nums.length + 1];

		for (int[] query : queries) {
			allQueries.offer(query);
		}

		int decrease = 0, useQuery = 0;

		for (int i = 0; i < nums.length; i++) {

			decrease -= expire[i];

			while (!allQueries.isEmpty() && allQueries.peek()[0] <= i) {
				usableQueries.offer(allQueries.poll());
			}

			while (nums[i] > decrease) {

				if (usableQueries.isEmpty() || usableQueries.peek()[1] < i)
					return -1;

				useQuery++;
				decrease++;
				expire[usableQueries.poll()[1] + 1]++;

			}

		}

		return queries.length - useQuery;
	}
}