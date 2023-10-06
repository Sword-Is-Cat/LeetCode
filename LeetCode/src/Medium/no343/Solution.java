package Medium.no343;

class Solution {
	public int integerBreak(int n) {

		if (n < 4)
			return n - 1;

		int[] arr = new int[n + 1];

		arr[1] = 1;

		for (int no = 2; no < arr.length; no++) {
			arr[no] = no;
			for (int i = 1; i <= no / 2; i++) {
				arr[no] = Math.max(arr[no], arr[i] * arr[no - i]);
			}
		}

		return arr[n];
	}
}