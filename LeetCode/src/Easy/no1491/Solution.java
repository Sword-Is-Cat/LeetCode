package Easy.no1491;

class Solution {
	public double average(int[] salary) {

		int sum = 0, min = salary[0], max = min;

		for (int value : salary) {
			sum += value;
			min = Math.min(min, value);
			max = Math.max(max, value);
		}

		return 1D * (sum - min - max) / (salary.length - 2);

	}
}