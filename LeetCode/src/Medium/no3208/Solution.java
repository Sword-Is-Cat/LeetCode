package Medium.no3208;

class Solution {
	public int numberOfAlternatingGroups(int[] colors, int k) {

		int length = colors.length;
		int countAlternate = 0, answer = 0;

		for (int i = 1; i < k; i++) {
			if (colors[i] != colors[i - 1]) {
				countAlternate++;
			}
		}

		for (int i = k; i < length + k; i++) {
			if (colors[i % length] != colors[(i - 1) % length]) {
				countAlternate++;
			}
			if (colors[i - k] != colors[(i - k + 1) % length]) {
				countAlternate--;
			}
			answer += countAlternate / (k - 1);
		}

		return answer;
	}
}