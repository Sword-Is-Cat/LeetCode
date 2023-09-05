package Medium.no138;

import java.util.HashMap;
import java.util.Map;

class Solution_ {
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

