package Challenge.September1st_1;

class Solution {

	int[] a;
	boolean[] visit;
	int answer = -1;

	public String largestTimeFromDigits(int[] A) {

		a = A;
		visit = new boolean[a.length];

		process(0, 0);

		if (answer < 0)
			return "";

		StringBuilder sb = new StringBuilder();

		if (answer / 100 > 9)
			sb.append(answer / 100);
		else {
			sb.append("0");
			sb.append(answer / 100);
		}

		sb.append(":");

		if (answer % 100 > 9)
			sb.append(answer % 100);
		else {
			sb.append("0");
			sb.append(answer % 100);
		}

		return sb.toString();

	}

	void process(int no, int length) {
		if (length == 4) {
			if (no < 2400 && no % 100 < 60)
				answer = Math.max(answer, no);
		} else {
			for (int i = 0; i < 4; i++) {
				if (!visit[i]) {
					visit[i] = true;
					process(no * 10 + a[i], length + 1);
					visit[i] = false;
				}
			}
		}
	}
}