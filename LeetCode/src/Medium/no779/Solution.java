package Medium.no779;

class Solution {
	public int kthGrammar(int n, int k) {

		k = k - 1;

		int sum = 0;

		while (k > 0) {
			sum += k % 2;
			k /= 2;
		}

		return sum % 2;

	}
}