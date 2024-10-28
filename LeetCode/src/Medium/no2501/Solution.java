package Medium.no2501;

class Solution {
	public int longestSquareStreak(int[] nums) {

		int[] arr = new int[100001];
		for (int num : nums) {
			arr[num] = 1;
		}

		int answer = -1;

		for (int i = 2; i < 320; i++) {
			if (arr[i] > 0) {
				if (i * i < arr.length && arr[i * i] > 0) {
					arr[i * i] += arr[i];
					answer = Math.max(answer, arr[i * i]);
				}
			}
		}

		return answer;
	}
}