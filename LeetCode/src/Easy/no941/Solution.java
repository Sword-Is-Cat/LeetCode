package Easy.no941;

class Solution {
	public boolean validMountainArray(int[] arr) {

		boolean isAsc = true;

		if (arr.length<3 || arr[0] > arr[1]) return false;

		for (int i = 0; i < arr.length - 1; i++) {

			int prev = arr[i];
			int next = arr[i + 1];

			if (prev == next) return false;

			if (isAsc) {
				if (prev > next)
					isAsc = false;
			} else {
				if (prev < next)
					return false;
			}
		}
		return !isAsc;
	}
}