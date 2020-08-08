package Easy.no590;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<Integer> list = new ArrayList<>();

	public List<Integer> postorder(Node root) {

		process(root);

		return list;

	}

	void process(Node node) {

		if (node == null)
			return;

		if (node.children.size() != 0)
			for (Node child : node.children)
				process(child);

		list.add(node.val);

	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};