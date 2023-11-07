package Medium.no1921;

import java.util.PriorityQueue;

class Solution {
	public int eliminateMaximum(int[] dist, int[] speed) {
		PriorityQueue<Double> que = new PriorityQueue<>();
		for (int i = 0; i < dist.length; i++)
			que.add(1D * dist[i] / speed[i]);
		int time = 0;
		while (!que.isEmpty() && time < que.poll())
			time++;
		return time;
	}
}