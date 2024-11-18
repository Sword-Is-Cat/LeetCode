package Easy.no1652;

class Solution {
	public int[] decrypt(int[] code, int k) {

		int length = code.length;
		int[] ans = new int[length];

		if (k == 0)
			return ans;

		int width = Math.abs(k), sum = 0;

		for (int i = 0; i < width; i++) {
			sum += code[i];
		}

		for (int i = 0; i < length; i++) {
			sum += code[(width + i) % length];
			sum -= code[i];
			if (k > 0) {
				ans[i] = sum;
			} else {
				ans[(width + i + 1) % length] = sum;
			}
		}

		return ans;
	}
}