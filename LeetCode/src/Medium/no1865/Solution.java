package Medium.no1865;

import java.util.HashMap;
import java.util.Map;

class FindSumPairs {

	Map<Integer, Integer> freq2 = new HashMap<>();
	int[] nums1, nums2;

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
		for (int num : nums2)
			freq2.put(num, freq2.getOrDefault(num, 0) + 1);
	}

	public void add(int index, int val) {
		freq2.put(nums2[index], freq2.getOrDefault(nums2[index], 0) - 1);
		nums2[index] += val;
		freq2.put(nums2[index], freq2.getOrDefault(nums2[index], 0) + 1);
	}

	public int count(int tot) {
		int result = 0;
		for (int num : nums1) {
			result += freq2.getOrDefault(tot - num, 0);
		}
		return result;
	}
}