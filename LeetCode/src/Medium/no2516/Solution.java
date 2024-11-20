package Medium.no2516;

class Solution {
	public int takeCharacters(String s, int k) {

		int length = s.length();
		int[][] cntL = new int[length + 1][3];
		int[][] cntR = new int[length + 1][3];

		for (int i = 1; i <= length; i++) {
			cntL[i][0] = cntL[i - 1][0];
			cntL[i][1] = cntL[i - 1][1];
			cntL[i][2] = cntL[i - 1][2];
			cntR[i][0] = cntR[i - 1][0];
			cntR[i][1] = cntR[i - 1][1];
			cntR[i][2] = cntR[i - 1][2];
			cntL[i][s.charAt(i - 1) - 'a']++;
			cntR[i][s.charAt(length - i) - 'a']++;
		}

		if (cntL[length][0] < k || cntL[length][1] < k || cntL[length][2] < k) {
			return -1;
		}

		int left = -1, right = length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			boolean rst = false;
			for (int leng = 0; leng <= mid; leng++) {
				rst |= (cntL[leng][0] + cntR[mid - leng][0] >= k) && (cntL[leng][1] + cntR[mid - leng][1] >= k)
						&& (cntL[leng][2] + cntR[mid - leng][2] >= k);
			}
			if (rst) {
				right = mid;
			} else {
				left = mid;
			}
		}

		return right;
	}
}