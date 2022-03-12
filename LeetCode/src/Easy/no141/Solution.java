package Easy.no141;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
    	if(head==null)return false;
        Set<ListNode> set = new HashSet<ListNode>();
        while(head.next!=null){
            if(!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}