package Medium.no138;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public Node copyRandomList(Node head) {
		
		Map<Node, Node> map = new HashMap<>();
		
		Node node = head;
		
		while(node!=null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}
		
		for(Node one : map.keySet()) {
			map.get(one).next = map.get(one.next);
			map.get(one).random = map.get(one.random);
		}
		
		return map.get(head);
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}