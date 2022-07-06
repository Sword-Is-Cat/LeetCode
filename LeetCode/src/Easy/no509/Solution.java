package Easy.no509;

class Solution {
	public int fib(int n) {

		int[] arr = new int[n + 1];

		for (int i = 0; i < arr.length; i++)
			arr[i] = i > 1 ? arr[i - 2] + arr[i - 1] : i;

		return arr[n];

	}
}