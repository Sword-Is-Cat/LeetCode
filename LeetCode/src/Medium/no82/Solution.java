package Medium.no82;

class Solution {
	public ListNode deleteDuplicates(ListNode head) {

		ListNode root = new ListNode(1000);
		ListNode node = root;
		root.next = head;

		while (node != null) {
			if (needDelete(node.next)) {
				node.next = findNextNotN(node.next, node.next.val);
			} else {
				node = node.next;
			}
		}

		return root.next;
	}

	boolean needDelete(ListNode node) {
		return node != null && node.next != null && node.val == node.next.val;
	}

	ListNode findNextNotN(ListNode node, int n) {
		while (node != null && node.val == n)
			node = node.next;
		return node;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}