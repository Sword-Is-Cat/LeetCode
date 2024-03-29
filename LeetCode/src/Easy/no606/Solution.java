package Easy.no606;

class Solution {
	public String tree2str(TreeNode root) {

		return process(new StringBuilder(), root).toString();

	}

	public StringBuilder process(StringBuilder sb, TreeNode node) {

		if (node != null) {

			sb.append(node.val);

			if (node.right != null) {
				sb.append("(");
				process(sb, node.left).append(")(");
				process(sb, node.right).append(")");
			} else if (node.left != null) {
				sb.append("(");
				process(sb, node.left).append(")");
			}

		}

		return sb;
	}
} 