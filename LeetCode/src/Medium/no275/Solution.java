package Medium.no275;

class Solution {
	public int hIndex(int[] citations) {

		int cnt = 1;

		for (cnt = 1; cnt <= citations.length; cnt++) {
			if (cnt > citations[citations.length - cnt])
				break;
		}

		return cnt - 1;
	}
}