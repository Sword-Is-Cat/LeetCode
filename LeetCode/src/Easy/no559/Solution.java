package Easy.no559;

import java.util.List;

class Solution {
	public int maxDepth(Node root) {

		if (root == null) return 0;

		int temp = 0;
		for (Node child : root.children)
			temp = Math.max(temp, maxDepth(child));

		return temp + 1;

	}
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}