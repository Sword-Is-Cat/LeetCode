package Easy.no876;

class Solution {
	public ListNode middleNode(ListNode head) {

		ListNode node = head;
		int cnt = 0;

		while (node != null) {
			node = node.next;
			cnt++;
		}

		cnt /= 2;

		node = head;

		while (cnt-- > 0)
			node = node.next;

		return node;
	}
}