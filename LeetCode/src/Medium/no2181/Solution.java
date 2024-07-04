package Medium.no2181;

class Solution {
	public ListNode mergeNodes(ListNode head) {

		ListNode node = head, prev = null;

		while (node.next != null) {

			if (node.next.val == 0) {
				prev = node;
				node = node.next;
			} else {
				node.val += node.next.val;
				node.next = node.next.next;
			}
		}

		prev.next = null;

		return head;

	}
}