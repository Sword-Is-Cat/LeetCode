package Medium.no109;

class Solution {
	public TreeNode sortedListToBST(ListNode head) {

		if(head == null)
			return null;
		
		ListNode node = head;
		int length = 1;

		while (node.next != null) {

			node = node.next;
			length++;

		}

		return proc(head, length);

	}

	public TreeNode proc(ListNode head, int length) {

		ListNode node = head;
		TreeNode rst;

		if (length < 4) {

			rst = new TreeNode(node.val);

			if (length > 1) {
				node = node.next;
				rst = new TreeNode(node.val, rst, null);
				if (length == 3) {
					node = node.next;
					rst.right = new TreeNode(node.val);
				}
			}

		} else {

			int le = length / 2;
			while (le > 0) {
				le--;
				node = node.next;
			}

			rst = new TreeNode(node.val, proc(head, length / 2), proc(node.next, length - length / 2 - 1));

		}

		return rst;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}