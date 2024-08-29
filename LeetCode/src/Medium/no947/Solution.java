package Medium.no947;

class Solution {

	int cntGroups;

	public int removeStones(int[][] stones) {

		cntGroups = 0;
		int[] uf = new int[20003];

		for (int[] stone : stones)
			setUnion(stone[0], stone[1], uf);

		return stones.length - cntGroups;
	}

	private void setUnion(int row, int col, int[] uf) {

		row += 1;
		col += 10002;

		int ur = getUnion(row, uf), uc = getUnion(col, uf);

		if (ur != uc) {
			uf[uc] = uf[ur];
			cntGroups--;
		}

	}

	private int getUnion(int val, int[] uf) {

		if (uf[val] == 0) {
			uf[val] = val;
			cntGroups++;
		}

		if (uf[val] != val)
			uf[val] = getUnion(uf[val], uf);

		return uf[val];
	}
}