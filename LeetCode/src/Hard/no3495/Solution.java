package Hard.no3495;

class Solution {
	
	public long minOperations(int[][] queries) {
		long answer = 0;
		for (int[] query : queries) {
			answer += (getAccumOperCnt(query[1]) - getAccumOperCnt(query[0] - 1) + 1) / 2;
		}
		return answer;
	}

	public long getAccumOperCnt(int value) {
		long result = 0;
		for (int i = 0; i < 16; i++) {
			long min = 1 << (i * 2), max = 1 << (i * 2 + 2);
			if (value < min)
				break;
			result += (i + 1) * (Math.min(max - 1, value) - min + 1);
		}
		return result;
	}
}