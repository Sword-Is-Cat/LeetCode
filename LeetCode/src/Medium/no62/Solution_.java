package Medium.no62;

class Solution_ {
	public int uniquePaths(int m, int n) {

		m--;
		n--;

		long head = 1;
		long tail = 1;
		int min = Math.min(m, n);

		for (int i = 0; i < min; i++) {
			head *= m + n - i;
			tail *= min - i;
		}

		long answer = head / tail;

		return (int) answer;

	}
}