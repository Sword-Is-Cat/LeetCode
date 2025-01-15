package Medium.no2657;

class Solution {
	public int[] findThePrefixCommonArray(int[] A, int[] B) {

		boolean[] occur = new boolean[A.length + 1];
		int cnt = 0;
		int[] ans = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			if (occur[A[i]])
				cnt++;
			occur[A[i]] = true;
			if (occur[B[i]])
				cnt++;
			occur[B[i]] = true;
			ans[i] = cnt;
		}

		return ans;

	}
}