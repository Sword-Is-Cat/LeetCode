package Easy.no1957;

class Solution {
	public String makeFancyString(String s) {

		StringBuilder sb = new StringBuilder();

		char prev = ' ';
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (prev != ch) {
				prev = ch;
				count = 0;
			}

			if (count < 2) {
				count++;
				sb.append(ch);
			}

		}

		return sb.toString();
	}
}