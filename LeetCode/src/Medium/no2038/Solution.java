package Medium.no2038;

class Solution {
	public boolean winnerOfGame(String colors) {

		colors += " ";
		char prev = (char) ('A' ^ 'B' ^ colors.charAt(0));
		int cnt = 0, temp = 0;

		for (char ch : colors.toCharArray()) {
			if (prev == ch) {
				temp++;
			} else {
				if (prev == 'A')
					cnt += Math.max(temp - 2, 0);
				else
					cnt -= Math.max(temp - 2, 0);
				prev = ch;
				temp = 1;
			}
		}

		return cnt > 0;
	}
}