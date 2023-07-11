package Medium.no863;

import java.util.ArrayList;
import java.util.List;

class Solution {

	ArrayList<Integer> ans;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

		ans = new ArrayList<>();

		scanDistanceToTarget(root, target, k);

		return ans;
	}

	private int scanDistanceToTarget(TreeNode node, TreeNode target, int k) {

		if (node == null) {
			return -1;
		} else if (node == target) {
			findDistancedNode(node, k);
			return 1;
		}

		int leftDist = scanDistanceToTarget(node.left, target, k);
		int rightDist = scanDistanceToTarget(node.right, target, k);

		if (leftDist == -1 && rightDist == -1)
			return -1;

		int dist = Math.max(leftDist, rightDist);
		if (dist == k) {
			ans.add(node.val);
			return -1;
		}

		findDistancedNode(leftDist == -1 ? node.left : node.right, k - dist - 1);

		return dist + 1;
	}

	private void findDistancedNode(TreeNode node, int distance) {

		if (node == null || distance < 0)
			return;

		if (distance == 0) {
			ans.add(node.val);
			return;
		}

		findDistancedNode(node.left, distance - 1);
		findDistancedNode(node.right, distance - 1);

	}
}