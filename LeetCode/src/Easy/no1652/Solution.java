package Easy.no1652;

class Solution {
	public int[] decrypt(int[] code, int k) {

		int[] ans = new int[code.length];
		int length = code.length;

		for (int i = 0; i < code.length; i++) {
			if (k < 0) {
				for (int j = 0; j > k; j--) {
					ans[i] += code[(length + i - 1 + j) % length];
				}
			} else if (k > 0) {
				for (int j = 0; j < k; j++) {
					ans[i] += code[(i + 1 + j) % length];
				}
			}
		}

		return ans;
	}
}