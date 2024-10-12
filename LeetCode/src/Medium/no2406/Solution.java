package Medium.no2406;

class Solution {
	public int minGroups(int[][] intervals) {

		int[] arr = new int[1000002];
		int min = 1000000, max = 1;

		for (int[] interval : intervals) {
			arr[interval[0]]++;
			arr[interval[1] + 1]--;
			min = Math.min(min, interval[0]);
			max = Math.max(max, interval[1]);
		}

		int answer = 0, counter = 0;
		for (int i = min; i <= max; i++) {
			counter += arr[i];
			answer = Math.max(answer, counter);
		}

		return answer;

	}
}