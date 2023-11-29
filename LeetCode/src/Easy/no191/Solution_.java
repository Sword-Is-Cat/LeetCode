package Easy.no191;

public class Solution_ {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {

		int answer = 0;

		for (int i = 0; i < 32; i++) {
			answer += n % 2;
			n >>= 1;
		}

		return answer > 0 ? answer : -answer;

	}
}