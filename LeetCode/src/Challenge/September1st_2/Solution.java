package Challenge.September1st_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

	List<Integer> list;

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

		list = new ArrayList<>();
		
		process(root1);
		process(root2);
		
		Collections.sort(list);

		return list;
	}

	void process(TreeNode node) {
		
		if (node == null)
			return;

		list.add(node.val);
		process(node.left);
		process(node.right);
		return;
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
