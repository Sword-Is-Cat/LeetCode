package Challenge.August1st_5;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int left;
	int right;

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> answer = new ArrayList<>();

		count(0, root);

		for (int i = 0; i <= right - left; i++)
			answer.add(new ArrayList<Integer>());

		process(-left, root, answer);
		
		return answer;

	}

	public void count(int index, TreeNode node) {

		left = left > index ? index : left;
		right = right < index ? index : right;

		if (node.left != null)
			count(index - 1, node.left);

		if (node.right != null)
			count(index + 1, node.right);

	}

	public void process(int index, TreeNode node, List<List<Integer>> list) {

		list.get(index).add(node.val);

		if (node.left != null)
			process(index - 1, node.left, list);

		if (node.right != null)
			process(index + 1, node.right, list);

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