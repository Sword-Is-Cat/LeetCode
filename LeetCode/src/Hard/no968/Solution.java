package Hard.no968;

class Solution {

	int cnt = 0;

	public int minCameraCover(TreeNode root) {

		if (process(root) == 0)
			cnt++;
		return cnt;
	}

	/**
	 * 
	 * @param node
	 * @return 0->내PT가 카메라 여야 함, 1->내가 카메라임, 2->내child가 카메라임
	 */
	int process(TreeNode node) {

		int status = 3;

		if (node.left == null && node.right == null) {
			status = -1;
		} else if (node.left == null) {
			status = process(node.right);
		} else if (node.right == null) {
			status = process(node.left);
		} else {
			status = Math.min(status, process(node.left));
			status = Math.min(status, process(node.right));
		}

		status = (status + 1) % 3;

		if (status == 1)
			cnt++;

		return status;
	}
}