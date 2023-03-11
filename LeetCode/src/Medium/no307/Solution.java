package Medium.no307;

class NumArray {

	SegmentNode[] leaves;
	SegmentNode root;

	public NumArray(int[] nums) {

		leaves = new SegmentNode[nums.length];
		root = new SegmentNode(0, nums.length - 1, nums, null);

	}

	public void update(int index, int val) {
		leaves[index].update(val);
	}

	public int sumRange(int left, int right) {
		return root.getRangeSum(left, right);
	}

	class SegmentNode {

		int lIdx, rIdx;
		Integer value;
		SegmentNode leftNode, rightNode, parent;

		SegmentNode(int lIdx, int rIdx, int[] values, SegmentNode parent) {

			this.lIdx = lIdx;
			this.rIdx = rIdx;
			this.parent = parent;

			if (lIdx == rIdx) {
				value = values[lIdx];
				leaves[lIdx] = this;
			} else {
				int mid = (lIdx + rIdx) / 2;
				this.leftNode = new SegmentNode(lIdx, mid, values, this);
				this.rightNode = new SegmentNode(mid + 1, rIdx, values, this);
			}
		}

		int getValue() {
			if (value == null) {
				value = leftNode.getValue() + rightNode.getValue();
			}
			return value;
		}

		void update(int newVal) {
			value = lIdx == rIdx ? newVal : null;
			if (parent != null)
				parent.update(newVal);
		}

		int getRangeSum(int left, int right) {

			if (left < lIdx || rIdx < right)
				throw new IndexOutOfBoundsException();

			if (left == lIdx && rIdx == right)
				return getValue();

			return (left <= leftNode.rIdx ? leftNode.getRangeSum(left, Math.min(right, leftNode.rIdx)) : 0)
					+ (rightNode.lIdx <= right ? rightNode.getRangeSum(Math.max(rightNode.lIdx, left), right) : 0);

		}

	}
}