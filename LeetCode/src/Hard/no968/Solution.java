package Hard.no968;

class Solution {

	int camCnt = 0;

	public int minCameraCover(TreeNode root) {

		if (process(root) == 0)
			camCnt++;
		return camCnt;
	}

	/**
	 * @param node
	 * @return 0 -> pt Node need to be CAM
	 * 		 , 1 -> this is CAM
	 * 		 , 2 -> one of my childNode is CAM
	 */
	int process(TreeNode node) {

		int status = 2;

		if (node != null) {

			status = Math.min(process(node.left), process(node.right));

			status = (status + 1) % 3;

			if (status == 1)
				camCnt++;
		}

		return status;
	}
}