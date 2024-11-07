package Medium.no2275;

class Solution {
	public int largestCombination(int[] candidates) {

		int answer = 1;

		for (int i = 0; i < 30; i++) {
			int cnt = 0;
			for (int num : candidates) {
				cnt += (num >> i) & 1;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;

	}
}