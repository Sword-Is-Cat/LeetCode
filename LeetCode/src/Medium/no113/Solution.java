package Medium.no113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

	List<List<Integer>> answer = new ArrayList<>();
	HashMap<TreeNode, TreeNode> findPT = new HashMap<>();
	int target;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		target = targetSum;

		findPT.put(root, null);
		process(root, 0);

		return answer;
	}

	public void process(TreeNode node, int sum) {

		if (node == null) {
			return;
		} else if (node.left != null || node.right != null) {

			sum += node.val;

			if (node.left != null) {
				findPT.put(node.left, node);
				process(node.left, sum);
			}

			if (node.right != null) {
				findPT.put(node.right, node);
				process(node.right, sum);
			}

		} else {

			if (sum + node.val != target)
				return;

			LinkedList<Integer> list = new LinkedList<>();

			while (node != null) {

				list.addFirst(node.val);
				node = findPT.get(node);

			}

			answer.add(list);

		}

	}
}