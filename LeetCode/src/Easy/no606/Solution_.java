package Easy.no606;

class Solution_ {

	StringBuilder sb = new StringBuilder();

	public String tree2str(TreeNode t) {

		process(t);

		return sb.toString();

	}

	void process(TreeNode node) {
		if (node != null) {
			sb.append(node.val);
			if (node.left != null && node.right == null) {
				sb.append('(');
				process(node.left);
				sb.append(')');
			} else if (node.left == null && node.right != null) {
				sb.append("()(");
				process(node.right);
				sb.append(')');
			} else if (node.left != null && node.right != null) {
				sb.append('(');
				process(node.left);
				sb.append(")(");
				process(node.right);
				sb.append(')');
			}
		}
	}
}
