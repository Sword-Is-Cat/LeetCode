package Easy.no203;

class Solution {
	public ListNode removeElements(ListNode head, int val) {

		while (head != null && head.val == val)
			head = head.next;

		ListNode temp = head;

		if (temp != null)
			while (temp.next != null) {
				if (temp.next.val == val)
					temp.next = temp.next.next;
				else
					temp = temp.next;
			}

		return head;

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
