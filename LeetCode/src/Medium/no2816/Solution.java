package Medium.no2816;

class Solution {
	public ListNode doubleIt(ListNode head) {

		ListNode root = new ListNode(0, head);

		doubleItDfs(root);

		return root.val == 0 ? root.next : root;
	}

	private void doubleItDfs(ListNode node) {

		node.val = (node.val * 2 % 10);

		if (node.next != null) {

			if (node.next.val >= 5) {
				node.val++;
			}

			doubleItDfs(node.next);

		}

	}

}