package Hard.no1569;

import java.util.HashMap;

class Solution {

	HashMap<Node, Integer> map;
	int mod = (int) 1e9 + 7;

	public int numOfWays(int[] nums) {

		map = new HashMap<>();
		Node root = buildBST(nums);

		return numOfWays(root) - 1;
	}

	private int numOfWays(Node node) {

		if (node == null)
			return 1;

		int lc = cntNode(node.left), rc = cntNode(node.right);

		long rst = binomialCoeff(lc + rc, Math.min(lc, rc));
		rst = (rst * numOfWays(node.left)) % mod;
		rst = (rst * numOfWays(node.right)) % mod;

		return (int) rst;
	}

	private long combi(int a, int b) {
		return b > 0 ? (combi(a - 1, b - 1) * a / b) % mod : 1;
	}
	
	private int binomialCoeff(int n, int k) {
        int[] c = new int[k + 1];
        c[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) 
                c[j] = (c[j] + c[j - 1]) % mod;
        }
        return c[k] % mod;
    }

	private int cntNode(Node node) {
		if (node == null)
			return 0;
		if (!map.containsKey(node))
			map.put(node, 1 + cntNode(node.left) + cntNode(node.right));
		return map.get(node);
	}

	private Node buildBST(int[] nums) {

		Node root = null;
		for (int num : nums)
			root = addNode(root, num);

		return root;
	}

	private Node addNode(Node node, int val) {

		if (node == null)
			node = new Node(val);
		else if (node.val < val)
			node.right = addNode(node.right, val);
		else if (node.val > val)
			node.left = addNode(node.left, val);

		return node;
	}

}

class Node {
	int val;
	Node left, right;

	Node(int _val) {
		val = _val;
	}
}