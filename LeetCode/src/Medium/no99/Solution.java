package Medium.no99;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public void recoverTree(TreeNode root) {

		Queue<TreeNode> nodeQ = new LinkedList<>();
		Queue<Integer> intQ = new PriorityQueue<>();
		
		fillQueue(root, nodeQ, intQ);
		
		while(!nodeQ.isEmpty() && !intQ.isEmpty()) {
			nodeQ.poll().val = intQ.poll();
		}
	}
	
	void fillQueue(TreeNode node, Queue<TreeNode> nodeQ, Queue<Integer> intQ) {
		
		if(node!=null) {
			
			fillQueue(node.left, nodeQ, intQ);
			
			nodeQ.add(node);
			intQ.add(node.val);
			
			fillQueue(node.right, nodeQ, intQ);
		}
	}
}