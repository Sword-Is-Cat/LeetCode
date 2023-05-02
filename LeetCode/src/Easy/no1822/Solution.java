package Easy.no1822;

class Solution {
	public int arraySign(int[] nums) {

		int rst = 1;

		for (int num : nums) {
			if (num == 0)
				return 0;
			if (num < 0)
				rst *= -1;
		}

		return rst;

	}
}