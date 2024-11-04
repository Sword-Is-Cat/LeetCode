package Medium.no3163;

class Solution {
	public String compressedString(String word) {

		StringBuilder sb = new StringBuilder();

		char prev = word.charAt(0);
		int cnt = 0;

		for (char ch : word.toCharArray()) {
			if (prev != ch || cnt == 9) {
				sb.append(cnt);
				sb.append(prev);
				prev = ch;
				cnt = 0;
			}
			cnt++;
		}
		sb.append(cnt);
		sb.append(prev);

		return sb.toString();
	}
}