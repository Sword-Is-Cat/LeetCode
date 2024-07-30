package Medium.no1653;

class Solution {
	public int minimumDeletions(String s) {

		char[] arr = s.toCharArray();

		int cntA = 0, cntB = 0, ans = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a') {
				cntA++;
			}
		}

		ans = cntA;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a') {
				cntA--;
			} else {
				cntB++;
			}
			ans = Math.min(ans, cntA + cntB);
		}

		return ans;

	}
}
