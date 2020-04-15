package Easy.no66;

class Solution {
	public int[] plusOne(int[] digits) {

		return plus(digits, digits.length - 1);

	}

	public int[] plus(int[] digits, int node) {

		if (node >= 0) {

			if (digits[node] == 9) {
				digits[node] = 0;
				return plus(digits, node - 1);
			} else {
				digits[node] += 1;
				return digits;
			}
		} else {
			int[] answer = new int[digits.length + 1];
			answer[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				answer[i + 1] = digits[i];
			}
			return answer;
		}
	}
}