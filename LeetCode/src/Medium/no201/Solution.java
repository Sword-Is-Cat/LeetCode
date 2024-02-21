package Medium.no201;

class Solution {
	public int rangeBitwiseAnd(int left, int right) {
		if (left < right) {
			return rangeBitwiseAnd(left / 2, right / 2) * 2;
		}
		return right;
	}
}
