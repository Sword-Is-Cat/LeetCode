package Medium.no2095;

class Solution {
	public ListNode deleteMiddle(ListNode head) {

		ListNode root = new ListNode(0, head);
		dfs(root, 0);

		return root.next;
	}

	int dfs(ListNode node, int idx) {

		int targetIdx = node.next == null ? idx / 2 : dfs(node.next, idx + 1);

		if (idx == targetIdx)
			node.next = node.next.next;

		return targetIdx;
	}
}