package Medium.no2415;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public TreeNode reverseOddLevels(TreeNode root) {
		List<TreeNode> curr = null, next = new ArrayList<>();
		int lv = 0;
		next.add(root);

		while (next.get(0) != null) {
			curr = next;
			next = new ArrayList<>();
			if (lv % 2 == 1) {
				for (int i = 0; i < curr.size() / 2; i++) {
					int temp = curr.get(curr.size() - 1 - i).val;
					curr.get(curr.size() - 1 - i).val = curr.get(i).val;
					curr.get(i).val = temp;
				}
			}
			for (TreeNode node : curr) {
				next.add(node.left);
				next.add(node.right);
			}
			lv++;
		}

		return root;
	}
}