package Medium.no1361;

class Solution {

	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

		UnionFind uf = new UnionFind(n);
		boolean[] visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			int left = leftChild[i], right = rightChild[i];

			if (left != -1) {
				if (visit[left])
					return false;
				visit[left] = true;
				uf.set(i, left);
			}

			if (right != -1) {
				if (visit[right])
					return false;
				visit[right] = true;
				uf.set(i, right);
			}

		}

		int cntFalse = 0;
		int root = uf.get(0);
		boolean validate = true;

		for (int i = 0; i < n; i++) {
			validate &= root == uf.get(i);
			cntFalse += visit[i] ? 0 : 1;
		}

		return validate && cntFalse == 1;
	}
}

class UnionFind {

	int[] uf;

	UnionFind(int n) {
		uf = new int[n];
		for (int i = 0; i < n; i++)
			uf[i] = i;
	}

	int get(int idx) {
		int value = uf[idx];
		if (value != idx)
			uf[idx] = get(value);
		return uf[idx];
	}

	void set(int parent, int child) {
		uf[child] = get(parent);
	}
}