package Medium.no287;

class Solution {
	public int findDuplicate(int[] nums) {
		boolean[] visit = new boolean[nums.length];
		for (int num : nums) {
			if (visit[num])
				return num;
			visit[num] = true;
		}
		return -1;
	}
}