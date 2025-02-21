package Medium.no1261;

class FindElements {

	private TreeNode root;

	public FindElements(TreeNode root) {
		this.root = root;
	}

	public boolean find(int target) {
		target++;
		int header = 1;
		while (header * 2 <= target) {
			header *= 2;
		}
		return find(root, target - header, header / 2);
	}

	private boolean find(TreeNode node, int target, int header) {
		if (node == null)
			return false;
		if (header == 0)
			return true;
		if (target >= header)
			return find(node.right, target - header, header / 2);
		else
			return find(node.left, target, header / 2);
	}
}