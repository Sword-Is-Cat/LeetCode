package Easy.no459;

class Solution {
	public boolean repeatedSubstringPattern(String s) {
		return (s + s).indexOf(s, 1) != s.length();
	}
}