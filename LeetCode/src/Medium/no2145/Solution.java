package Medium.no2145;

class Solution {
	public int numberOfArrays(int[] differences, int lower, int upper) {

		long temp = 0, min = 0, max = 0;
		for (int num : differences) {
			temp += num;
			min = Math.min(min, temp);
			max = Math.max(max, temp);
		}

		return (int)Math.max(0, upper - lower - max + min + 1);

	}
}