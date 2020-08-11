package Easy.no617;

class Solution {
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		TreeNode answer = process(t1, t2);
		
		return answer;
	}
	
	TreeNode process(TreeNode t1, TreeNode t2) {
		
		TreeNode result;
		
		if(t1==null && t2==null)
			result = null;
		else if(t1==null && t2!=null)
			result = t2;
		else if(t1!=null && t2==null)
			result = t1;
		else {
			result = new TreeNode(t1.val+t2.val, process(t1.left, t2.left), process(t1.right, t2.right));
		}
		
		return result;
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