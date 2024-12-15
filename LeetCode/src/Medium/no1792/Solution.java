package Medium.no1792;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public double maxAverageRatio(int[][] classes, int extraStudents) {

		Queue<Container> que = new PriorityQueue<>((a, b) -> Double.compare(b.incRate, a.incRate));
		for (int[] item : classes) {
			que.offer(new Container(item[0], item[1]));
		}

		while (extraStudents-- > 0) {
			que.offer(que.poll().increase());
		}

		double answer = 0D;

		while (!que.isEmpty()) {
			Container item = que.poll();
			answer += item.pass / item.total;
		}

		return answer / classes.length;
	}
}

class Container {
	public double pass;
	public double total;
	public double incRate;

	public Container(int pass, int total) {
		this.pass = pass;
		this.total = total;
		update();
	}

	public Container increase() {
		pass++;
		total++;
		update();
		return this;
	}

	private void update() {
		incRate = (pass + 1) / (total + 1) - pass / total;
	}
}