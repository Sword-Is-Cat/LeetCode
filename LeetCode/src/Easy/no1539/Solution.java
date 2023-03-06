package Easy.no1539;

class Solution {
	public int findKthPositive(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (i + k < arr[i]) {
				return i + k;
			}
		}
		return arr.length + k;
	}
}