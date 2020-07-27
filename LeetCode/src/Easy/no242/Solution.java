package Easy.no242;

import java.util.Arrays;

class Solution {
	public boolean isAnagram(String s, String t) {
		
		if(s.length()!=t.length())
			return false;

		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();

		Arrays.sort(arrS);
		Arrays.sort(arrT);

		boolean answer = true;

		for (int i = 0; i < arrS.length; i++) {
			if (arrS[i] != arrT[i]) {
				answer = false;
				break;
			}
		}

		return answer;

	}
}