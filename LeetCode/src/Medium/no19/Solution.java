package Medium.no19;

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode root = new ListNode(0, head);

		dfs(root, n);

		return root.next;

	}

	int dfs(ListNode node, int n) {

		if (node == null)
			return n;

		int rst = dfs(node.next, n);

		if (rst == 0)

			node.next = node.next.next;

		return rst - 1;
	}
}