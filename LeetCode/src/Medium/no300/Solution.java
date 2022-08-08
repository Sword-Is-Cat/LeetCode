package Medium.no300;

import java.util.ArrayList;

class Solution {

	ArrayList<Integer> list = new ArrayList<>();

	public int lengthOfLIS(int[] nums) {

		for (int num : nums) {

			int size = list.size();

			if (size == 0 || list.get(size - 1) < num)
				list.add(num);
			else
				list.set(getIndex(num), num);
		}

		return list.size();
	}

	int getIndex(int num) {

		int left = -1, right = list.size() - 1;

		while (right - left > 1) {

			int mid = (left + right) / 2;

			if (list.get(mid) < num)
				left = mid;
			else
				right = mid;

		}
		return right;
	}
}