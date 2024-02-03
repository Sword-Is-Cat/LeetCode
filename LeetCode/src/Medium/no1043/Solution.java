package Medium.no1043;

class Solution {
	public int maxSumAfterPartitioning(int[] arr, int k) {

		int[] sums = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			int max = arr[i];
			for (int leng = 0; leng < Math.min(i + 1, k); leng++) {
				max = Math.max(max, arr[i - leng]);
				sums[i + 1] = Math.max(sums[i + 1], sums[i - leng] + (leng + 1) * max);
			}
		}

		return sums[arr.length];
	}
}