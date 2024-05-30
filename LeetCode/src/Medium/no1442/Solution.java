package Medium.no1442;

class Solution {
	public int countTriplets(int[] arr) {
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				temp ^= arr[j];
				if (temp == 0) {
					ans += j - i;
				}
			}
		}

		return ans;
	}
}