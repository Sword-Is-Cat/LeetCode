package Hard.no458;

class Solution {

	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

		int caseEachPig = minutesToTest / minutesToDie + 1;
		int cases = 1, pigs = 0;

		while (cases < buckets) {
			cases *= caseEachPig;
			pigs++;
		}

		return pigs;
	}
}