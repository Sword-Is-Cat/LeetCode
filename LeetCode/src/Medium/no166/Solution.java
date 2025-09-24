package Medium.no166;

import java.util.HashMap;

class Solution {
	public String fractionToDecimal(int numerator, int denominator) {

		if (numerator == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		if (numerator < 0 ^ denominator < 0)
			sb.append("-");
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		sb.append(num / den);
		num %= den;

		if (num == 0)
			return sb.toString();
		sb.append(".");

		HashMap<Long, Integer> map = new HashMap<>();

		while (num != 0) {

			if (map.containsKey(num)) {
				int i = map.get(num);
				sb.insert(i, "(");
				sb.append(")");
				return sb.toString();
			}

			map.put(num, sb.length());
			num *= 10;
			sb.append(num / den);
			num %= den;

		}

		return sb.toString();

	}
}