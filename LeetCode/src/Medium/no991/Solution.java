package Medium.no991;

class Solution {
	public int brokenCalc(int startValue, int target) {

		int cnt = 0;

		while (startValue != target) {

			if (startValue < target) {

				cnt++;
				if (target % 2 == 0)
					target /= 2;
				else
					target += 1;

			} else {
				cnt += startValue - target;
				target = startValue;
			}
		}
		return cnt;
	}
}