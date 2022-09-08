package Easy.no94;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<Integer> list = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {

		if (root != null) {
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		}

		return list;

	}
}