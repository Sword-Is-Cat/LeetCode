package Medium.no237;

class Solution {
	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;
	}
}