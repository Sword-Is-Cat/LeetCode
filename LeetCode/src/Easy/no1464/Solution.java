package Easy.no1464;

class Solution {
	public int maxProduct(int[] nums) {

		int m1 = 0, m2 = 0;

		for (int num : nums) {
			if (m1 <= num) {
				m2 = m1;
				m1 = num;
			} else if (m2 < num) {
				m2 = num;
			}
		}

		return (m1 - 1) * (m2 - 1);
	}
}