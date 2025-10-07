package Medium.no1488;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
	public int[] avoidFlood(int[] rains) {

		int len = rains.length;
		// 해당 day에 비가온 lake에 다음 비가올 날짜. -1이면 마지막 비임
		int[] nextRain = new int[len], empty = new int[0];
		HashMap<Integer, Integer> rainMap = new HashMap<>();
		for (int day = len - 1; day >= 0; day--) {
			int lakeNo = rains[day];
			if (lakeNo > 0) {
				nextRain[day] = rainMap.getOrDefault(lakeNo, -1);
				rainMap.put(lakeNo, day);
			} else {
				nextRain[day] = -1;
			}
		}
		System.out.println(Arrays.toString(nextRain));

		rainMap.clear();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int[] answer = new int[len];
		for (int day = 0; day < len; day++) {
			int lakeNo = rains[day];
			if (lakeNo == 0) {
				if (que.isEmpty()) {
					answer[day] = 1;
				} else {
					int nextRainDay = que.poll(), nextLakeNo = rains[nextRainDay];
					answer[day] = nextLakeNo;
					rainMap.put(nextLakeNo, -1);
				}
			} else {
				answer[day] = -1;
				if (rainMap.getOrDefault(lakeNo, -1) != -1) {
					return empty;
				}
				rainMap.put(lakeNo, day);
				if (nextRain[day] != -1)
					que.offer(nextRain[day]);
			}
		}

		return answer;
	}
}