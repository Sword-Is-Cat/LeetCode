package Hard.no587;

import java.util.Collection;
import java.util.HashSet;

class Solution {

	HashSet<int[]> rst = new HashSet<>();
	boolean debug = false;

	public int[][] outerTrees(int[][] trees) {

		int[] left = trees[0], right = trees[0];

		for (int[] tree : trees) {

			print("[" + tree[0] + "," + tree[1] + "]");

			if (tree[0] < left[0] || (tree[0] == left[0] && tree[1] < left[1])) {
				print("LEFT");
				left = tree;
			}
			if (tree[0] > right[0] || (tree[0] == right[0] && tree[1] > right[1])) {
				print("RIGHT");
				right = tree;
			}
		}

		rst.add(left);
		rst.add(right);

		dfs(trees, left, right, 1);
		dfs(trees, left, right, -1);

		return collectionToArray(rst);
	}

	void dfs(int[][] trees, int[] tree1, int[] tree2, int order) {

		if (tree1[0] > tree2[0]) {
			int[] temp = tree1;
			tree1 = tree2;
			tree2 = temp;
		}

		if (tree1[0] == tree2[0] && tree1[1] > tree2[1]) {
			int[] temp = tree1;
			tree1 = tree2;
			tree2 = temp;
		}

		int a = tree2[1] - tree1[1], b = tree2[0] - tree1[0];
		int max = (a * tree1[0] - b * tree1[1]) * order, dist = 0;
		int[] temp = null;
		print("[" + tree1[0] + "," + tree1[1] + "],[" + tree2[0] + "," + tree2[1] + "] max:" + max);

		for (int[] tree : trees) {
			if (rst.contains(tree))
				continue;
			int tempVal = (a * tree[0] - b * tree[1]) * order;
			print(" [" + tree[0] + "," + tree[1] + "] val:" + tempVal);
			if (tempVal >= max) {
				max = tempVal;
				temp = tree;
			}
		}

		if (temp != null) {
			print(" >> [" + temp[0] + "," + temp[1] + "] val:" + max);
			rst.add(temp);
			dfs(trees, tree1, temp, order);
			dfs(trees, temp, tree2, order);
		}

	}

	int[][] collectionToArray(Collection<int[]> collect) {

		int size = collect.size();
		int[][] array = new int[size][];

		for (int[] data : collect)
			array[--size] = data;

		return array;
	}

	void print(String str) {
		if (debug)
			System.out.println(str);
	}

	public static void main(String[] args) {
		int[][] trees = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 2 }, { 3, 2 }, { 3, 1 }, { 3, 0 }, { 2, 0 },
				{ 1, 0 }, { 1, 1 }, { 3, 3 } };
		System.out.println(new Solution().outerTrees(trees).length);
	}
}