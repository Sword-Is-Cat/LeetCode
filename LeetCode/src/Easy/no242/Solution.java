package Easy.no242;

class Solution {
	public boolean isAnagram(String s, String t) {

		int[] counterS = new int[26], counterT = new int[26];

		for (char ch : s.toCharArray())
			counterS[ch - 'a']++;

		for (char ch : t.toCharArray())
			counterT[ch - 'a']++;

		boolean answer = true;

		for (int i = 0; answer && i < 26; i++)
			answer &= counterS[i] == counterT[i];

		return answer;
	}
}
