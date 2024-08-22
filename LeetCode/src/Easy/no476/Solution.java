package Easy.no476;

class Solution {
	public int findComplement(int num) {
		int temp = num, mask = 1;
		while (temp > 0) {
			temp >>= 1;
			mask <<= 1;
		}
		mask--;
		return mask ^ num;
	}
}