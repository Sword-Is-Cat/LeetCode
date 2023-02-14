package Medium.no2140;

class Solution {
	public long mostPoints(int[][] questions) {

		long result = 0;
		// [0] 진행상황 저장할 배열 선언
		long[] arr = new long[questions.length];

		for (int idx = 0; idx < arr.length; idx++) {

			int point = questions[idx][0], brainpower = questions[idx][1];
			int nextIdx = -1;

			// [1-1] idx번 문제를 푼다
			nextIdx = idx + brainpower + 1;
			if (nextIdx < arr.length) {
				arr[nextIdx] = Math.max(arr[nextIdx], arr[idx] + point);
			} else {
				result = Math.max(result, arr[idx] + point);
			}

			// [1-2] idx번 문제를 풀지 않는다
			nextIdx = idx + 1;
			if (nextIdx < arr.length) {
				arr[nextIdx] = Math.max(arr[nextIdx], arr[idx]);
			} else {
				result = Math.max(result, arr[idx]);
			}

		}
		return result;
	}
}