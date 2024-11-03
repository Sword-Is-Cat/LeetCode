package Easy.no796;

class Solution {
	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (goal + goal).indexOf(s) > -1;
	}
}