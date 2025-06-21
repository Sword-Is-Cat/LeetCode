package Medium.no3443;

class Solution {
	public int maxDistance(String s, int k) {

		int[] cnts = new int[4];
		int answer = 0;

		for (char ch : s.toCharArray()) {
			switch (ch) {
			case 'N':
				cnts[0]++;
				break;
			case 'S':
				cnts[1]++;
				break;
			case 'E':
				cnts[2]++;
				break;
			case 'W':
				cnts[3]++;
				break;
			}

			int k1 = Math.min(k, Math.min(cnts[0], cnts[1])), k2 = Math.min(k - k1, Math.min(cnts[2], cnts[3]));
			answer = Math.max(answer, Math.abs(cnts[0] - cnts[1]) + Math.abs(cnts[2] - cnts[3]) + 2 * k1 + 2 * k2);

		}

		return answer;
	}
}