package Easy.no167;

class Solution {
	public int[] twoSum(int[] numbers, int target) {

		int i = 0, j = numbers.length - 1;

		while (i < j) {

			if (numbers[i] + numbers[j] < target)
				i++;
			else if (numbers[i] + numbers[j] > target)
				j--;
			else
				break;
		}

		int[] answer = { i + 1, j + 1 };
		return answer;

	}
}