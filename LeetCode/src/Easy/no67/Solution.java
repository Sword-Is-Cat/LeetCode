package Easy.no67;

class Solution {
	public String addBinary(String a, String b) {

		StringBuilder sb = new StringBuilder();
		int zero = '0', value = 0, lengthA = a.length(), lengthB = b.length();

		while (lengthA-- > 0 | lengthB-- > 0) {

			if (lengthA >= 0)
				value += a.charAt(lengthA) - zero;
			if (lengthB >= 0)
				value += b.charAt(lengthB) - zero;

			sb.append(value % 2);
			value /= 2;
		}

		if (value == 1)
			sb.append(value);
		return sb.reverse().toString();
	}
}