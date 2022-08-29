package Medium.no1007;

class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {

		int tVal = tops[0];
		int bVal = bottoms[0];

		int ttCnt = 0;
		int tbCnt = 0;
		int btCnt = 0;
		int bbCnt = 0;

		boolean topPossible = true;
		boolean botPossible = true;

		for (int i = 0; i < tops.length; i++) {

			if (topPossible) {
				ttCnt += tVal == tops[i] ? 1 : 0;
				tbCnt += tVal == bottoms[i] ? 1 : 0;
				topPossible &= tVal == tops[i] || tVal == bottoms[i];
			}

			if (botPossible) {
				btCnt += bVal == tops[i] ? 1 : 0;
				bbCnt += bVal == bottoms[i] ? 1 : 0;
				botPossible &= bVal == tops[i] || bVal == bottoms[i];
			}

		}

		int tCnt = Math.min(tops.length - ttCnt, tops.length - tbCnt);
		int bCnt = Math.min(tops.length - btCnt, tops.length - bbCnt);

		int rst = -1;

		if (topPossible && botPossible)
			rst = Math.min(tCnt, bCnt);
		else
			rst = topPossible ? tCnt : botPossible ? bCnt : -1;

		return rst;
	}
}