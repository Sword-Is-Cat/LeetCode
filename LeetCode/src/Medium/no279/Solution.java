package Medium.no279;

class Solution {

	int answer = 0;

	public int numSquares(int n) {
		
		answer = n;

		process(n, (int)Math.sqrt(n), 0);

		return answer;

	}

	public void process(int no, int sqNo, int cnt) {
		
		if (no < 0 || cnt > answer || sqNo == 0) {
			return;
		} else if (no == 0) {

			answer = Math.min(answer, cnt);
			return;

		} else {

			process(no - sqNo * sqNo, sqNo, cnt + 1);
			process(no, sqNo - 1, cnt);

		}
	}
}