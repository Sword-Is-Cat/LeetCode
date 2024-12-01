package Easy.no1346;

class Solution {
	public boolean checkIfExist(int[] arr) {

		boolean[] exist = new boolean[4001];
		boolean[] visit = new boolean[4001];
		for (int no : arr) {
			if (visit[no + 2000])
				if (no == 0)
					return true;
				else
					continue;
			if (exist[no + 2000] || exist[no * 2 + 2000])
				return true;
			else
				visit[no + 2000] = exist[no + 2000] = exist[no * 2 + 2000] = true;
		}

		return false;

	}
}