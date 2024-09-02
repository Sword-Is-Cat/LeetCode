package Medium.no1894;

class Solution {
	public int chalkReplacer(int[] chalk, int k) {

		for (int i = 0; i < chalk.length; i++) {
			if (i > 0)
				chalk[i] += chalk[i - 1];
			if (chalk[i] > k)
				return i;
		}

		k %= chalk[chalk.length - 1];

		for (int i = 0; i < chalk.length; i++) {
			if (chalk[i] > k)
				return i;
		}

		return -1;
	}
}