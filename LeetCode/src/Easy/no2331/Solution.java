package Easy.no2331;

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val<2) {
        	return root.val == 1;
        }else if(root.val == 2) {
        	return evaluateTree(root.left) || evaluateTree(root.right);
        }else if(root.val == 3) {
        	return evaluateTree(root.left) && evaluateTree(root.right);
        }else {
        	return false;
        }
    }
}