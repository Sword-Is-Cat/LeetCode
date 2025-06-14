package Easy.no2566;

class Solution {
	public int minMaxDifference(int num) {

		// get max remapped num
		int prefix = getPrefixDigit(num, 9);
		int maxVal = remapDigit(num, prefix, 9);

		// get min remapped num
		prefix = getPrefixDigit(num, 0);
		int minVal = remapDigit(num, prefix, 0);

		return maxVal - minVal;
	}

	private int getPrefixDigit(int num, int ban) {
		if (num == 0)
			return -1;
		int digit = num % 10;
		int result = getPrefixDigit(num / 10, ban);
		return result == -1 ? digit == ban ? -1 : digit : result;
	}

	private int remapDigit(int num, int from, int to) {
		if (num == 0)
			return 0;
		int digit = num % 10;
		if (digit == from)
			digit = to;
		int result = remapDigit(num / 10, from, to);
		return result * 10 + digit;
	}
}