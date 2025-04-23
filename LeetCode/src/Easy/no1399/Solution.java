package Easy.no1399;

class Solution {
	public int countLargestGroup(int n) {

		int[] occur = new int[40];
		while (n > 0) {
			occur[digitSum(n--)]++;
		}

		int maxSize = 0, count = 0;

		for (int size : occur) {
			if (maxSize < size) {
				maxSize = size;
				count = 1;
			} else if (maxSize == size) {
				count++;
			}
		}

		return count;
	}

	private int digitSum(int num) {
		int result = 0;
		while (num > 0) {
			result += num % 10;
			num /= 10;
		}
		return result;
	}
}