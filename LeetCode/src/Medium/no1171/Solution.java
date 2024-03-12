package Medium.no1171;

class Solution {
	public ListNode removeZeroSumSublists(ListNode head) {

		if (head != null) {

			int sum = 0;
			ListNode node = head;

			while (node != null) {
				sum += node.val;
				if (sum == 0) {
					return removeZeroSumSublists(node.next);
				}
				node = node.next;
			}

			head.next = removeZeroSumSublists(head.next);
		}
		return head;

	}
}