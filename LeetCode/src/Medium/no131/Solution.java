package Medium.no131;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<List<String>> ans = new ArrayList<>();
	String str;
	char[] arr;
	boolean[][] isPalin;

	public List<List<String>> partition(String s) {

		str = s;
		arr = s.toCharArray();
		isPalin = new boolean[arr.length][arr.length];

		for (int left = 0; left < arr.length; left++) {
			for (int right = left; right < arr.length; right++) {
				isPalin[left][right] = isPalindrome(left, right);
			}
		}

		dfs(new ArrayList<>(), 0, 0);

		return ans;
	}

	protected void dfs(List<String> list, int prev, int curr) {

		if (curr == arr.length) {
			if (prev == curr)
				ans.add(list);
			return;
		}

		// [1] palindrome 이라면 list추가하는 case 처리
		if (isPalin[prev][curr]) {
			List<String> clone = new ArrayList<>(list);
			clone.add(new String(str.substring(prev, curr + 1)));
			dfs(clone, curr + 1, curr + 1);
		}
		// [2] list 추가없이 진행
		dfs(list, prev, curr + 1);
	}

	protected boolean isPalindrome(int left, int right) {

		while (left < right) {
			if (arr[left] != arr[right])
				return false;
			left++;
			right--;
		}
		return true;
	}
}