package Easy.no141;

import java.util.HashSet;
import java.util.Set;

public class Solution_ {
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