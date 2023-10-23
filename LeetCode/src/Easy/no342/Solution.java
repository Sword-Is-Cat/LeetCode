package Easy.no342;

class Solution {
	public boolean isPowerOfFour(int num) {
		return num == 0 ? false : num == 1 ? true : num % 4 == 0 ? isPowerOfFour(num / 4) : false;
	}
}