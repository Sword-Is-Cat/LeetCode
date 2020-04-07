package Easy.no7;

/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31,  2^31 - 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

class Solution {
	public int reverse(int x) {

		StringBuilder sb = new StringBuilder();
		boolean minus = (x < 0) ? true : false;
		x = (x < 0) ? -x : x;

		while (x > 0) {
			sb.append(x % 10);
			x = x / 10;
		}

		int y = 0;
		
		try {
		y = Integer.parseInt(sb.toString());
		}catch (Exception e) {
			return 0;
		}
		
		y = (minus) ? -y : y;

		return y;

	}
}