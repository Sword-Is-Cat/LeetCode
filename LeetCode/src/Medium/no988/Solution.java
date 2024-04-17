package Medium.no988;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

	HashMap<TreeNode, TreeNode> ptMap = new HashMap<>();

	public String smallestFromLeaf(TreeNode root) {

		return new String(dfs(root, 1));
	}

	private char[] dfs(TreeNode node, int depth) {

		char[] result;

		if (node.left == null && node.right == null) {
			result = new char[depth];
			Arrays.fill(result, 'a');
			for (int i = 0; i < depth; i++) {
				result[i] += node.val;
				node = ptMap.get(node);
			}
		} else if (node.left == null) {
			ptMap.put(node.right, node);
			result = dfs(node.right, depth + 1);
		} else if (node.right == null) {
			ptMap.put(node.left, node);
			result = dfs(node.left, depth + 1);
		} else {
			ptMap.put(node.left, node);
			ptMap.put(node.right, node);
			result = compareCharArr(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
		}

		return result;

	}

	private char[] compareCharArr(char[] arr1, char[] arr2) {

		int leng = Math.min(arr1.length, arr2.length);

		for (int i = 0; i < leng; i++) {
			if (arr1[i] != arr2[i]) {
				return arr1[i] < arr2[i] ? arr1 : arr2;
			}
		}
		return arr1.length == leng ? arr1 : arr2;
	}
}