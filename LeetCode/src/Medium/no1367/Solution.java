package Medium.no1367;

class Solution {
	public boolean isSubPath(ListNode head, TreeNode root) {

		if (root == null)
			return false;

		if (isSubPathDfs(head, root))
			return true;

		return isSubPath(head, root.left) || isSubPath(head, root.right);

	}

	public boolean isSubPathDfs(ListNode head, TreeNode root) {

		if (head == null)
			return true;
		else if (root == null)
			return false;
		else if (head.val == root.val)
			return isSubPathDfs(head.next, root.left) || isSubPathDfs(head.next, root.right);
		else
			return false;

	}
}