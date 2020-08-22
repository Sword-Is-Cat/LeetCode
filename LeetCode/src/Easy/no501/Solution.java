package Easy.no501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	Map<Integer, Integer> map = new HashMap<>();

	public int[] findMode(TreeNode root) {
		dfs(root);
		List<Integer> l = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i : map.keySet()) {
			if (map.get(i) > max) {
				max = map.get(i);
				l.clear();
			} else if (map.get(i) < max)
				continue;
			l.add(i);
		}
		int i = 0, res[] = new int[l.size()];
		for (int n : l)
			res[i++] = n;
		return res;
	}

	private void dfs(TreeNode node) {
		if (node == null)
			return;
		map.put(node.val, map.getOrDefault(node.val, 0) + 1);
		dfs(node.left);
		dfs(node.right);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}