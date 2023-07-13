package Medium.no207;

import java.util.ArrayList;

class Solution {

	boolean[] checked, canTake;
	ArrayList<ArrayList<Integer>> required;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		checked = new boolean[numCourses];
		canTake = new boolean[numCourses];
		required = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			required.add(new ArrayList<>());

		for (int[] require : prerequisites)
			required.get(require[0]).add(require[1]);

		boolean ans = true;
		for (int courseNum = 0; ans && courseNum < numCourses; courseNum++)
			ans &= canTake(courseNum);

		return ans;
	}

	private boolean canTake(int index) {
		if (!checked[index]) {
			checked[index] = true;
			boolean flag = true;
			for (int req : required.get(index))
				flag &= canTake(req);
			canTake[index] = flag;
		}
		return canTake[index];
	}
}