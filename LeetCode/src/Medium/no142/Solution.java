package Medium.no142;

public class Solution {
	public ListNode detectCycle(ListNode head) {

		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}

		return head;
	}
}