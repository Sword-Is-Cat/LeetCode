package Medium.no2429;

class Solution {
	public int minimizeXor(int num1, int num2) {

		int bc1 = Integer.bitCount(num1), bc2 = Integer.bitCount(num2);

		if (bc1 == bc2)
			return num1;

		int target = bc1 > bc2 ? 1 : 0, count = Math.abs(bc1 - bc2), shift = 0;

		while (count > 0) {
			if ((num1 & 1) == target)
				count--;
			num1 >>= 1;
			shift++;
		}

		if (bc1 > bc2)
			return num1 << shift;

		while (shift-- > 0) {
			num1 <<= 1;
			num1 |= 1;
		}

		return num1;
	}
}