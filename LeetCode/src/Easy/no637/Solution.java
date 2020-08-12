package Easy.no637;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<Double> answer = new ArrayList<>();
	List<Integer> count = new ArrayList<>();

	public List<Double> averageOfLevels(TreeNode root) {

		process(root, 0);

		for (int i = 0; i < answer.size(); i++) {
			answer.set(i, answer.get(i) / count.get(i));
		}

		return answer;

	}

	void process(TreeNode node, int index) {

		if (node == null)
			return;

		if (answer.size() > index) {
			answer.set(index, answer.get(index) + node.val);
			count.set(index, count.get(index) + 1);
		} else {
			answer.add((double) node.val);
			count.add(1);
		}

		process(node.left, index + 1);
		process(node.right, index + 1);

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