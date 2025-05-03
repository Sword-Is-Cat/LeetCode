package Medium.no1007;

class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {

		int flip = Math.min(Math.min(getFlipCount(tops, bottoms, tops[0]), getFlipCount(bottoms, tops, bottoms[0])),
				Math.min(getFlipCount(tops, bottoms, bottoms[0]), getFlipCount(bottoms, tops, tops[0])));

		return Math.min(flip, tops.length - flip);
	}

	private int getFlipCount(int[] arr, int[] arr2, int target) {
		int flip = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				continue;
			} else if (arr2[i] == target) {
				flip++;
			} else {
				return arr.length + 1;
			}
		}
		return flip;
	}
}