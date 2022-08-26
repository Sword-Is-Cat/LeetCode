package Medium.no869;

class Solution {

	final static int CHECK = 1073741824;

	public boolean reorderedPowerOf2(int n) {

		String str = Integer.toString(n);
		int[] counter = new int[10];

		for (int i = 0; i < str.length(); i++)
			counter[(int) (str.charAt(i) - '0')]++;

		return dfs(counter, 0, true);

	}

	public boolean dfs(int[] counter, int value, boolean isFirst) {

		boolean isEnd = true;

		for (int cnt : counter) {
			if (cnt != 0) {
				isEnd = false;
				break;
			}
		}

		if (isEnd) {
			return CHECK % value == 0;
		} else {

			boolean result = false;

			for (int i = 0; i < 10; i++) {

				if (i == 0 && isFirst)
					continue;

				if (counter[i] > 0) {
					counter[i]--;
					result |= dfs(counter, value * 10 + i, false);
					counter[i]++;
				}

			}
			return result;

		}

	}
}