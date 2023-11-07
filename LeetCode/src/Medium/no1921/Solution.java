package Medium.no1921;

import java.util.PriorityQueue;

class Solution {
	public int eliminateMaximum(int[] dist, int[] speed) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < dist.length; i++)
			que.add(dist[i] / speed[i]);
		int time = 0;
		while (time <= que.poll())
			time++;
		return time;
	}
}