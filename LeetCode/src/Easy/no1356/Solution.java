package Easy.no1356;

import java.util.Arrays;

class Solution {
	public int[] sortByBits(int[] arr) {
		Integer[] list = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			list[i] = arr[i];
		Arrays.sort(list, (a, b) -> {
			int ca = Integer.bitCount(a), cb = Integer.bitCount(b);
			int rst = ca - cb;
			return rst == 0 ? a - b : rst;
		});
		for (int i = 0; i < arr.length; i++)
			arr[i] = list[i];
		return arr;
	}
}