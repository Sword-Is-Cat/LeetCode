package Hard.no239;

class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {

		Node root = new Node(0, nums.length - 1, nums);

		int[] ans = new int[nums.length - k + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = findMaxNode(root, i, i + k - 1).value;
		}

		return ans;
	}

	protected Node findMaxNode(Node node, int l, int r) {

		if (l < node.li || node.ri < r)
			return null;
		else if (l == node.li && r == node.ri)
			return getMaxNode(node);
		else if (r <= node.left.ri)
			return findMaxNode(node.left, l, r);
		else if (node.right.li <= l)
			return findMaxNode(node.right, l, r);
		else
			return comparing(findMaxNode(node.left, l, node.left.ri), findMaxNode(node.right, node.right.li, r));
	}

	protected Node getMaxNode(Node node) {
		if (node.maxNode == null) {
			node.maxNode = node.li == node.ri ? node : comparing(getMaxNode(node.left), getMaxNode(node.right));
		}
		return node.maxNode;
	}

	protected Node comparing(Node nodeA, Node nodeB) {
		return nodeA.value < nodeB.value ? nodeB : nodeA;
	}
}

/**
 * define SegmentNode
 */
class Node {
	int li, ri, value;
	Node left, right, parent, maxNode;

	Node(int li, int ri, int[] nums) {

		this.li = li;
		this.ri = ri;

		if (li == ri) {
			// leafNode
			value = nums[li];
		} else {
			int mid = (li + ri) / 2;
			left = new Node(li, mid, nums);
			left.parent = this;
			right = new Node(mid + 1, ri, nums);
			right.parent = this;
		}
	}
}