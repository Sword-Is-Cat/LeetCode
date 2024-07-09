package Medium.no1701;

class Solution {
	public double averageWaitingTime(int[][] customers) {

		int time = 0;
		double wait = 0;

		for (int[] info : customers) {

			time = Math.max(time, info[0]) + info[1];
			wait += time - info[0];

		}

		return wait / customers.length;
	}
}