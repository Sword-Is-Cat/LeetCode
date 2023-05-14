package Hard.no1799;

class Solution {
	public int maxScore(int[] nums) {

		boolean[] visit = new boolean[nums.length];
		int[] cache = new int[(int) Math.pow(2, nums.length)];

		return dfs(nums, visit, cache);
	}

	private int dfs(int[] nums, boolean[] visit, int[] cache) {

		boolean isEnd = true;
		int num = 0;
		for (boolean flag : visit) {
			isEnd &= flag;
			if (flag) {
				num++;
			}
		}

		if (isEnd) {
			return 0;
		}

		num = num / 2 + 1;

		int index = parseBinary(visit);

		if (cache[index] == 0) {

			int rst = 0;

			for (int i = 0; i < nums.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					for (int j = i + 1; j < nums.length; j++) {
						if (!visit[j]) {
							visit[j] = true;
							rst = Math.max(rst, num * gcd(nums[i], nums[j]) + dfs(nums, visit, cache));
							visit[j] = false;
						}
					}
					visit[i] = false;
				}
			}

			cache[index] = rst;

		}

		return cache[index];
	}

	private int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	private int parseBinary(boolean[] visit) {
		int rst = 0;

		for (boolean flag : visit) {
			rst *= 2;
			if (flag)
				rst++;
		}
		return rst;
	}
}