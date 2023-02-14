package Medium.no1689;

class Solution {
	public int minPartitions(String n) {

		int max = 0;
		int zero = (int) '0';

		for (char ch : n.toCharArray())
			max = Math.max(max, ch - zero);

		return max;
	}
}