package Medium.no2929;

class Solution {
	public long distributeCandies(int n, int limit) {

		int minFirst = Math.max(0, n - limit * 2), maxFirst = Math.min(limit, n);
		long answer = 0;

		for (int first = minFirst; first <= maxFirst; first++) {
			int remain = n - first;
			int minSecond = Math.max(0, remain - limit), maxSecond = Math.min(limit, remain);
			answer += maxSecond - minSecond + 1;
		}

		return answer;
	}
}