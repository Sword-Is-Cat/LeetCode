package Easy.no1009;

class Solution {
	public int bitwiseComplement(int n) {

		int length = Integer.toString(n, 2).length();

		return (int) Math.pow(2, length) - 1 - n;

	}
}