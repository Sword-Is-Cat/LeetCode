package Medium.no2375;

class Solution {

	boolean isComplete = false;

	public String smallestNumber(String pattern) {
		char[] patternArr = pattern.toCharArray();
		char[] answer = new char[patternArr.length + 1];
		boolean[] used = new boolean[10];
		for (int i = 1; !isComplete && i <= 9; i++) {
			used[i] = true;
			answer[0] = (char) (i + '0');
			dfs(patternArr, answer, used, 0);
			used[i] = false;
		}
		return new String(answer);
	}

	private void dfs(char[] patternArr, char[] answer, boolean[] used, int idx) {
		if (idx == patternArr.length) {
			isComplete = true;
			return;
		}
		int from = 1, to = 9;
		if (patternArr[idx] == 'I') {
			from = answer[idx] - '0' + 1;
		} else {
			to = answer[idx] - '0' - 1;
		}
		for (int num = from; !isComplete && num <= to; num++) {
			if (!used[num]) {
				used[num] = true;
				answer[idx + 1] = (char) (num + '0');
				dfs(patternArr, answer, used, idx + 1);
				used[num] = false;
			}
		}
	}
}