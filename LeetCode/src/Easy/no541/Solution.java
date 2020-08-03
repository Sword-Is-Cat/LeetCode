package Easy.no541;

class Solution {
	public String reverseStr(String s, int k) {

		StringBuilder sb = new StringBuilder();

		boolean reverse = true;

		while (s.length() > k) {

			StringBuilder temp = new StringBuilder();

			temp.append(s.substring(0, k));
			s = s.substring(k);

			if (reverse) {
				sb.append(temp.reverse());
				reverse = false;
			} else {
				sb.append(temp);
				reverse = true;
			}
		}

		StringBuilder temp = new StringBuilder();
		temp.append(s);

		if (reverse)
			sb.append(temp.reverse());
		else
			sb.append(temp);

		return sb.toString();

	}
}