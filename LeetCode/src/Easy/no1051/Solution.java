package Easy.no1051;

class Solution {
	public int heightChecker(int[] heights) {

		int[] heightFreq = new int[101];
		for (int height : heights) {
			heightFreq[height]++;
		}

		int ans = 0, targetHeight = 0;

		for (int height : heights) {
			while (heightFreq[targetHeight] == 0) {
				targetHeight++;
			}
			heightFreq[targetHeight]--;
			if (height != targetHeight) {
				ans++;
			}
		}

		return ans;

	}
}