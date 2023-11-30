package Hard.no1611;

class Solution {

	final char chngChar = '0' ^ '1';

	public int minimumOneBitOperations(int n) {

		char[] binaryCharArray = Integer.toBinaryString(n).toCharArray();
		int length = binaryCharArray.length;

		int ans = 0;

		for (int i = 0; i < length - 1; i++) {
			if (binaryCharArray[i] != '0') {
				ans += Math.pow(2, length - i - 1);
				binaryCharArray[i] ^= chngChar;
				binaryCharArray[i + 1] ^= chngChar;
			}
		}

		if (binaryCharArray[length - 1] != '0')
			ans++;

		return ans;
	}
}