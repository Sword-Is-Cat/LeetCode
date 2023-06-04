package Medium.no547;

class Solution {

	int[] uf;

	public int findCircleNum(int[][] isConnected) {

		int length = isConnected.length;
		uf = new int[length];
		for (int i = 0; i < length; i++) {
			uf[i] = i;
		}

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (isConnected[i][j] == 1) {
					setUF(i, j);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < length; i++) {
			if (getUF(i) == i) {
				ans++;
			}
		}
		return ans;
	}

	private void setUF(int a, int b) {
		int ufa = getUF(a), ufb = getUF(b);
		if (ufa < ufb) {
			uf[ufb] = ufa;
		} else {
			uf[ufa] = ufb;
		}
	}

	private int getUF(int a) {

		int ufa = uf[a];

		if (ufa != a) {
			uf[a] = getUF(ufa);
		}

		return uf[a];
	}
}