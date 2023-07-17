package Medium.no445;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int dep1 = depth(l1), dep2 = depth(l2), max = Math.max(dep1, dep2);

		while (dep1++ <= max)
			l1 = new ListNode(0, l1);
		while (dep2++ <= max)
			l2 = new ListNode(0, l2);

		plus(l1, l2);

		while (l1.val == 0 && l1.next != null)
			l1 = l1.next;

		return l1;
	}

	private int plus(ListNode node1, ListNode node2) {

		if (node1 == null || node2 == null)
			return 0;

		int value = node1.val + node2.val + plus(node1.next, node2.next);
		node1.val = node2.val = value % 10;

		return value / 10;

	}

	private int depth(ListNode node) {
		if (node == null)
			return 0;
		return 1 + depth(node.next);
	}
}