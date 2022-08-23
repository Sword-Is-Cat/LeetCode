package Easy.no234;

class Solution {

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;

		ListNode tail = head;
		ListNode temp = null;

		while (tail.next != null && tail.next.next != null) {

			temp = new ListNode(head.val, temp);
			head = head.next;
			tail = tail.next.next;

		}

		if (tail.next != null)
			temp = new ListNode(head.val, temp);

		head = head.next;

		while (head != null && temp != null) {

			if (head.val != temp.val)
				return false;

			head = head.next;
			temp = temp.next;

		}

		return true;
	}
}