package Easy.no530;

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	List<Integer> list = new ArrayList<>();
	
	public int getMinimumDifference(TreeNode root) {
		
		nodeToList(root);
		
		if(list.size()<2)return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1 ; i<list.size() ; i++) {
			min = Math.min(min, Math.abs(list.get(i-1)-list.get(i)));
		}
		
		return min;

	}
	
	public void nodeToList(TreeNode node) {
		
		if(node == null) return;
		
		nodeToList(node.left);
		list.add(node.val);
		nodeToList(node.right);
		
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