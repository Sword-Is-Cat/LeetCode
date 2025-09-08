package Easy.no1317;

class Solution {
	public int[] getNoZeroIntegers(int n) {

		if (n < 19) {
			int half = n / 2;
			return new int[] { half, n - half };
		}

		int temp = n % 10;
		if (temp < 2) {
			n -= 10;
			temp += 10;
		}

		int half = temp / 2;
		int[] rst = getNoZeroIntegers(n / 10);
		rst[0] = rst[0] * 10 + half;
		rst[1] = rst[1] * 10 + temp - half;

		return rst;

	}
}