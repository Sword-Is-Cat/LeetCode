package Medium.no2683;

class Solution {
	public boolean doesValidArrayExist(int[] derived) {
		int mask = 0;
		for (int num : derived)
			mask ^= num;
		return mask == 0;
	}
}