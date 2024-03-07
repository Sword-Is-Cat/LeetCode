package Easy.no876;

class Solution {
	public ListNode middleNode(ListNode head) {

		ListNode forward = head, backward = head;

		while (forward != null && forward.next != null) {
			forward = forward.next.next;
			backward = backward.next;
		}

		return backward;
	}
}