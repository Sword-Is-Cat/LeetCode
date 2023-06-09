package Easy.no744;

class Solution {
	public char nextGreatestLetter(char[] letters, char target) {

		int left = -1, right = letters.length;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (target < letters[mid])
				right = mid;
			else
				left = mid;
		}

		return letters[right % letters.length];

	}
}