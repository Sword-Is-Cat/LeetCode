package Easy.no168;

class Solution {
	public String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();

		while (n > 0) {

			if (n % 26 == 0) {
				sb.append('Z');
				n -= 26;
				n /= 26;
			} else {
				sb.append((char) (n % 26 + 64));
				n /= 26;
			}
		}

		return sb.reverse().toString();

	}
}