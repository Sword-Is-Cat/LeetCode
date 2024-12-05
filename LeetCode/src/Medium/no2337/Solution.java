package Medium.no2337;

class Solution {
	public boolean canChange(String start, String target) {

		int stackR = 0, needL = 0;

		for (int i = 0; i < start.length(); i++) {
			char sChar = start.charAt(i), tChar = target.charAt(i);
			if (sChar == 'R') {
				if (needL > 0)
					return false;
				stackR++;
			}
			if (tChar == 'L') {
				if (stackR > 0)
					return false;
				needL++;
			}
			if (tChar == 'R') {
				if (stackR == 0)
					return false;
				stackR--;
			}
			if (sChar == 'L') {
				if (needL == 0)
					return false;
				needL--;
			}
		}

		return stackR == 0 && needL == 0;

	}
}