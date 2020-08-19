package Easy.no234;

class Solution {
	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;

		ListNode temp1 = head;
		ListNode temp2 = head;
		ListNode reverse = null;

		while (temp2.next != null && temp2.next.next != null) {
			reverse = new ListNode(temp1.val, reverse);
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}

		if (temp2.next != null) {
			if (temp1.val != temp1.next.val)
				return false;
			else
				temp1 = temp1.next;
		}

		temp1 = temp1.next;

		while (temp1 != null) {
			if (temp1.val != reverse.val) {
				return false;
			} else {
				temp1 = temp1.next;
				reverse = reverse.next;
			}
		}

		return true;
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