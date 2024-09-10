package Medium.no2807;

class Solution {
	public ListNode insertGreatestCommonDivisors(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			node.next = new ListNode(gcd(node.val, node.next.val), node.next);
			node = node.next.next;
		}
		return head;
	}

	public int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}