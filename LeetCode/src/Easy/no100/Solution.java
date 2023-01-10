package Easy.no100;

class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// [1]둘다 null인 경우 true
		if (p == null && q == null)
			return true;
		// [2] 한쪽만 null인 경우 false
		if (p == null ^ q == null)
			return false;
		// [3] 둘다 null 이 아닌경우
		// [3-1] value가 다른경우 false
		if (p.val != q.val)
			return false;
		// [3-2] 두 노드의 value가 같다면, left노드 및 right노드의 일치여부 반환
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}