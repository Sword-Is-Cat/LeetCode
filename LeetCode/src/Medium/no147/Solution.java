package Medium.no147;

class Solution {
	public ListNode insertionSortList(ListNode head) {

		ListNode dummy = new ListNode(-5001);

		while (head != null) {

			ListNode next = head.next;
			inserting(dummy, head);
			head = next;

		}

		return dummy.next;
	}

	void inserting(ListNode exist, ListNode newNode) {

		newNode.next = null;

		if (exist.next == null) {
			exist.next = newNode;
		} else {

			if (newNode.val < exist.next.val) {
				newNode.next = exist.next;
				exist.next = newNode;
			} else {
				inserting(exist.next, newNode);
			}

		}

	}
}