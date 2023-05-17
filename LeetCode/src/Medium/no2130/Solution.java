package Medium.no2130;

class Solution {

	ListNode cache;
	int max = 0;

	public int pairSum(ListNode head) {

		cache = head;
		process(head);

		return max;

	}

	private void process(ListNode node) {

		if (node == null)
			return;

		process(node.next);

		max = Math.max(max, node.val + cache.val);
		cache = cache.next;

	}
}