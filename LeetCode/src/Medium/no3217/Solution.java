package Medium.no3217;

class Solution {
	public ListNode modifiedList(int[] nums, ListNode head) {
		boolean[] banned = new boolean[100001];
		for (int num : nums)
			banned[num] = true;
		ListNode root = new ListNode(0, head), node = root;
		while (node != null && node.next != null) {
			if (banned[node.next.val])
				node.next = node.next.next;
			else
				node = node.next;
		}
		return root.next;
	}
}