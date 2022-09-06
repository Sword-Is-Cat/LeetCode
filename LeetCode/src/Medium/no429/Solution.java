package Medium.no429;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> list = new ArrayList<>();

		process(list, root, 0);

		return list;

	}

	void process(List<List<Integer>> list, Node node, int depth) {

		if (node == null)
			return;

		if (list.size() == depth)
			list.add(new ArrayList<>());

		list.get(depth).add(node.val);

		for (Node child : node.children)
			process(list, child, depth + 1);

	}
}