package Medium.no1578;

import java.util.PriorityQueue;

class Solution {
	public int minCost(String colors, int[] neededTime) {

		PriorityQueue<Integer> que = new PriorityQueue<>();
		int answer = 0;
		que.add(neededTime[0]);

		for (int i = 1; i <= neededTime.length; i++) {

			if (i == neededTime.length || colors.charAt(i - 1) != colors.charAt(i)) {

				while (que.size() > 1)
					answer += que.poll();

				que.clear();

			}
			if (i < neededTime.length)
				que.add(neededTime[i]);

		}

		return answer;
	}
}