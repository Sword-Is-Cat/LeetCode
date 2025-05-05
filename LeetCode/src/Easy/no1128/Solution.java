package Easy.no1128;

class Solution {
	public int numEquivDominoPairs(int[][] dominoes) {

		int[][] counter = new int[10][10];
		int answer = 0;

		for (int[] domino : dominoes) {
			int low = Math.min(domino[0], domino[1]), high = Math.max(domino[0], domino[1]);
			answer += counter[low][high]++;
		}

		return answer;

	}
}