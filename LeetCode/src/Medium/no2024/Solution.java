package Medium.no2024;

class Solution {
	public int maxConsecutiveAnswers(String answerKey, int k) {

		char[] keyArr = answerKey.toCharArray();
		char[] chars = { 'T', 'F' };

		int maxLength = 0;
		for (char target : chars) {

			int left = 0, right = 0, cntChange = 0;

			while (right < keyArr.length) {

				if (keyArr[right] == target) {
					right++;
				} else if (cntChange < k) {
					right++;
					cntChange++;
				} else if (keyArr[left] == target) {
					left++;
				} else {
					left++;
					cntChange--;
				}

				maxLength = Math.max(maxLength, right - left);

			}
		}

		return maxLength;
	}
}