package Easy.no160;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	ListNode answer = null;
    	
    	ListNode tempA = headA;
    	ListNode tempB = headB;
    	
    	while(tempA != tempB) {
    		
    		if(tempA==null)
    			break;
    		else if(tempB == null) {
    			tempA = tempA.next;
    			tempB = headB;
    		}else {
    			tempB = tempB.next;
    		}
    		
    	}
    	
    	answer = tempA;
    	
    	return answer;
    	
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