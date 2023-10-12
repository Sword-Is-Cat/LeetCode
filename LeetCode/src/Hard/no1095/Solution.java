package Hard.no1095;

class Solution {
	public int findInMountainArray(int target, MountainArray mountainArr) {

		int left = 0, right = mountainArr.length() - 1, top = -1;

		while (left < right) {
			top = (left + right) / 2;
			if (left < top && mountainArr.get(top - 1) < mountainArr.get(top)) {
				left = top;
			} else if (top < right && mountainArr.get(top) > mountainArr.get(top + 1)) {
				right = top;
			}
		}

		int topValue = mountainArr.get(top);

		if (topValue == target)
			return top;

		int ans = -1;

		ans = binarySearchFromMountainArr(mountainArr, 0, top, target, true);
		if (ans == -1)
			ans = binarySearchFromMountainArr(mountainArr, top, mountainArr.length(), target, false);

		return ans;
	}

	private int binarySearchFromMountainArr(MountainArray mta, int left, int right, int target, boolean isAscend) {

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			int midVal = mta.get(mid);
			if ((isAscend && midVal <= target) || (!isAscend && target <= midVal))
				left = mid;
			else
				right = mid;
		}

		return mta.get(left) == target ? left : -1;
	}
}