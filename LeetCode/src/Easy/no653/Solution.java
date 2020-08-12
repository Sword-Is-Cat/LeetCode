package Easy.no653;

import java.util.HashSet;
import java.util.Set;

class Solution {
	
	Set<Integer> set = new HashSet<>();
	boolean isEnd = false;
	
	public boolean findTarget(TreeNode root, int k) {
		
		if(root==null || isEnd)
			return false;
		
		if(set.add(root.val) && set.add(k-root.val)) {
			findTarget(root.left, k);
			findTarget(root.right, k);
		}else if(root.val * 2 == k){
			findTarget(root.left, k);
			findTarget(root.right, k);
		}else{
			isEnd=true;
		}
		
		return isEnd;

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