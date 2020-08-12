package Easy.no657;

class Solution {
	public boolean judgeCircle(String moves) {

		char[] arr = moves.toCharArray();

		int x = 0, y = 0;

		for (char ch : arr) {
			switch (ch) {
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			}
		}

		return x == 0 && y == 0;
	}
}