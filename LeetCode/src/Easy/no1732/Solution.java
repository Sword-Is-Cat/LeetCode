package Easy.no1732;

class Solution {
	public int largestAltitude(int[] gain) {

		int height = 0, max = 0;

		for (int vari : gain) {
			height += vari;
			max = Math.max(max, height);
		}

		return max;

	}
}