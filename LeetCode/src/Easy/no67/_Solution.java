package Easy.no67;

class _Solution {
	public String addBinary(String a, String b) {

		char[] lo, st, answer;

		if (a.length() < b.length()) {
			lo = b.toCharArray();
			st = a.toCharArray();
		} else {
			lo = a.toCharArray();
			st = b.toCharArray();
		}

		int temp = 0;
		answer = new char[lo.length];

		for (int i = 0; i < lo.length; i++) {
			if (i > st.length-1) {
				int pro = lo[lo.length - 1 - i] + temp;
				if (pro > 49) {
					pro -= 2;
					temp = 1;
				} else
					temp = 0;
				answer[lo.length - 1 - i] = (char) pro;
			} else {
				int pro = lo[lo.length - 1 - i] + st[st.length - 1 - i] + temp - 48;
				if (pro > 49) {
					pro -= 2;
					temp = 1;
				} else
					temp = 0;
				answer[lo.length - 1 - i] = (char) pro;

			}
		}

		if (temp == 0)
			return new String(answer);
		else
			return "1" + new String(answer);

	}
}
