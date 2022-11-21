package Medium.no1927;

class Solution {
	public boolean sumGame(String num) {

		int leng = num.length();

		int dif = 0, cnt = 0;

		for (int idx = 0; idx < leng; idx++) {

			if (idx < leng / 2) {
				if (num.charAt(idx) == '?')
					cnt++;
				else
					dif += num.charAt(idx) - '0';
			} else {
				if (num.charAt(idx) == '?')
					cnt--;
				else
					dif -= num.charAt(idx) - '0';
			}
		}

		return dif * 2 + cnt * 9 != 0;
	}
}