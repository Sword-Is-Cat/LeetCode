package Medium.no1052;

class Solution {
	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

		int satisfy = 0, temp = 0, max = 0;

		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				satisfy += customers[i];
				customers[i] = 0;
			} else {
				temp += customers[i];
			}
			if (i >= minutes) {
				temp -= customers[i - minutes];
			}
			if (i >= minutes - 1) {
				max = Math.max(max, temp);
			}
		}

		return satisfy + max;
	}
}