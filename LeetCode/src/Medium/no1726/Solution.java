package Medium.no1726;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int tupleSameProduct(int[] nums) {

		Arrays.sort(nums);
		int ans = 0;

		for (int i1 = 0; i1 < nums.length; i1++) {
			for (int i4 = i1 + 1; i4 < nums.length; i4++) {

				int prod = nums[i1] * nums[i4];
				Set<Integer> set = new HashSet<>();

				for (int i2 = i1 + 1; i2 < i4; i2++) {

					int val = nums[i2];

					if (prod % val == 0) {
						if (set.contains(val))
							ans++;
						set.add(prod / val);
					}

				}
			}
		}

		return ans * 8;
	}
}