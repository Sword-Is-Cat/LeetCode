package Easy.no1422;

class Solution {
	public int maxScore(String s) {

		char[] arr = s.toCharArray();
		int ans = 0, sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '1')
				sum++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				ans = Math.max(ans, sum);
			if (arr[i] == '0')
				sum++;
			else
				sum--;
		}

		return ans;
	}
}