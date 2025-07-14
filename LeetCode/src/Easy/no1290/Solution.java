package Easy.no1290;

class Solution {
	public int getDecimalValue(ListNode head) {
		ListNode node = head;
		int result = 0;
		while (node != null) {
			result = result * 2 + node.val;
			node = node.next;
		}
		return result;
	}
}