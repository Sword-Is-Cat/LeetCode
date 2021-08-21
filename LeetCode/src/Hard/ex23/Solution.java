package Hard.ex23;

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {

		ListNode root = new ListNode();
		ListNode head = root;
		
		while(hasNotNull(lists)) {
			
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for(int i = 0 ; i<lists.length ; i++) {
				if(lists[i] != null && lists[i].val < min) {
					min = lists[i].val;
					index = i;
				}
					
			}
			
			head.next = lists[index];
			head = head.next;
			lists[index] = lists[index].next;
			
		}
		
		return root.next;
	}

	
	public boolean hasNotNull(ListNode[] lists) {
		for(ListNode node : lists) {
			if(node != null)
				return true;
		}
		return false;
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