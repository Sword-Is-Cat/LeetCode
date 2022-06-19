package Hard.ex65;

class Solution {
	public boolean isNumber(String s) {

		System.out.println("isNumber[" + s + "]");
		boolean rst = true;

		if (s.isEmpty())
			rst = false;
		else {
			s = s.toLowerCase();
			int idx = s.indexOf('e');

			if (idx == -1) {
				rst = !s.isEmpty() && isDemical(s);
			} else {
				String prev = s.substring(0, idx);
				String next = s.substring(idx + 1);
				rst = !prev.isEmpty() && !next.isEmpty() && isDemical(prev) && isInteger(next);
			}

		}

		return rst;
	}

	boolean isDemical(String s) {
		System.out.println("isDemical[" + s + "]");
		if (s.charAt(0) == '-' || s.charAt(0) == '+')
			s = s.substring(1);
		return !s.isEmpty() && isUnsignedDemical(s);
	}

	boolean isUnsignedDemical(String s) {
		System.out.println("isUsDemical[" + s + "]");
		boolean rst = true;

		int idx = s.indexOf('.');

		if (idx == -1)
			rst = isUnsignedInteger(s);
		else {
			String prev = s.substring(0, idx);
			String next = s.substring(idx + 1);
			rst = (!prev.isEmpty() || !next.isEmpty()) && isUnsignedInteger(prev) && isUnsignedInteger(next);
		}

		return rst;
	}

	boolean isInteger(String s) {
		System.out.println("isInteger:[" + s + "]");
		if (s.charAt(0) == '-' || s.charAt(0) == '+')
			s = s.substring(1);
		return !s.isEmpty() && isUnsignedInteger(s);
	}

	boolean isUnsignedInteger(String s) {
		System.out.println("isUsInteger:[" + s + "]");
		return s.replaceAll("[0-9]", "").isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isNumber("95a54e53"));
	}
}