package Medium.no382;

class Solution {

	ListNode root;

	public Solution(ListNode head) {
		root = head;
	}

	public int getRandom() {

		int result = 0, count = 1;
		ListNode node = root;

		while (node != null) {
			if (Math.random() * count++ < 1)
				result = node.val;
			node = node.next;
		}

		return result;
	}
}