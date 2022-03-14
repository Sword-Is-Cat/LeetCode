package Easy.no1672;

class Solution {
	public int maximumWealth(int[][] accounts) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < accounts.length; i++) {
			int temp = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				temp += accounts[i][j];
			}
			max = Math.max(max, temp);
		}
		return max;
	}
}