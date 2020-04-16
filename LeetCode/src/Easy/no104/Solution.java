package Easy.no104;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//class Solution {
//
//	int answer;
//
//	public int maxDepth(TreeNode root) {
//
//		maxDepth(root, 0);
//
//		return answer;
//
//	}
//
//	public void maxDepth(TreeNode root, int depth) {
//
//		if (root == null)
//			answer = (answer > depth) ? answer : depth;
//
//		else {
//			maxDepth(root.left, depth + 1);
//			maxDepth(root.right, depth + 1);
//		}
//
//	}
//}