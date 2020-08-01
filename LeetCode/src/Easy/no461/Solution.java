package Easy.no461;

class Solution {
	public int hammingDistance(int x, int y) {

		int z = x ^ y;

		int answer = 0;

		while (z > 0) {
			answer += z % 2;
			z /= 2;
		}

		return answer;

	}
}