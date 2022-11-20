package Hard.no224;

class Solution {
	public int calculate(String s) {

		// System.out.println("input: " + s);

		s = s.replaceAll(" ", "");
		s = s.trim();

		StringBuilder sub = new StringBuilder();
		StringBuilder str = new StringBuilder();

		int cntBra = 0;

		for (char ch : s.toCharArray()) {

			if (cntBra > 0 || ch == '(') {

				if (ch == ')')
					cntBra--;

				if (cntBra > 0)
					sub.append(ch);

				if (ch == '(')
					cntBra++;

				if (cntBra == 0) {
					str.append(calculate(sub.toString()));
					sub = new StringBuilder();
				}

			} else {
				str.append(ch);
			}

		}

		s = str.toString();
		// System.out.println("process: " + s);

		str = new StringBuilder();
		int val = 0, operate = 1;

		for (char ch : s.toCharArray()) {

			if (ch == '+' || ch == '-') {

				if (str.length() > 0) {

					val += operate * Integer.parseInt(str.toString());
					str = new StringBuilder();
					operate = 1;
				}

				if (ch == '-')
					operate *= -1;

			} else {
				str.append(ch);
			}

		}
		val += operate * Integer.parseInt(str.toString());
		// System.out.println("result: " + val);
		return val;
	}
}