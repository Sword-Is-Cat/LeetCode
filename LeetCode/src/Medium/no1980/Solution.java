package Medium.no1980;

class Solution {
	public String findDifferentBinaryString(String[] nums) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append((char) ('0' ^ '1' ^ nums[i].charAt(i)));
		}
		return sb.toString();

	}
}