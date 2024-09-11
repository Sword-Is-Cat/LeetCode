package Easy.no2220;

class Solution {
	public int minBitFlips(int start, int goal) {
		int target = start ^ goal, answer = 0;
		while (target > 0) {
			answer += target & 1;
			target >>= 1;
		}
		return answer;
	}
}