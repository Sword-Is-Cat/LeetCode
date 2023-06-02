package Medium.no2101;

class Solution {

	boolean[][] effects;
	boolean[] chained;

	public int maximumDetonation(int[][] bombs) {

		// 2D boolean array effects[i][j] : bombs[i] can blow bombs[j]
		// 1D boolean array chained[i] : effects[i] calculated chain-blow effect
		effects = new boolean[bombs.length][bombs.length];
		chained = new boolean[bombs.length];

		// check every bombs effective (except chain-blow)
		for (int i = 0; i < bombs.length; i++) {
			for (int j = i; j < bombs.length; j++) {
				if (i == j) {
					effects[i][i] = true;
				} else {
					int[] bomb1 = bombs[i], bomb2 = bombs[j];
					double distance = Math.sqrt(Math.pow(bomb2[0] - bomb1[0], 2) + Math.pow(bomb2[1] - bomb1[1], 2));
					effects[i][j] = distance <= bomb1[2];
					effects[j][i] = distance <= bomb2[2];
				}
			}
		}

		int ans = 1;

		for (int i = 0; i < bombs.length; i++) {
			ans = Math.max(ans, countTrues(getChainedEffect(i)));
		}

		return ans;
	}

	private boolean[] getChainedEffect(int index) {

		if (!chained[index]) {
			chained[index] = true;
			for (int bomb = 0; bomb < chained.length; bomb++) {
				if (index == bomb)
					continue;
				if (effects[index][bomb]) {
					boolean[] myEff = effects[index], bombEff = getChainedEffect(bomb);
					for (int i = 0; i < myEff.length; i++) {
						myEff[i] |= bombEff[i];
					}
				}

			}

		}
		return effects[index];

	}

	private int countTrues(boolean[] array) {
		int result = 0;
		for (boolean flag : array) {
			if (flag)
				result++;
		}
		return result;
	}

}