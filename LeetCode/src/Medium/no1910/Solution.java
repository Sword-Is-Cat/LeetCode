package Medium.no1910;

class Solution {
	public String removeOccurrences(String s, String part) {
		StringBuilder sb = new StringBuilder(s);
		int idx = sb.indexOf(part), partLength = part.length();
		while (idx > -1) {
			sb.delete(idx, idx + partLength);
			idx = sb.indexOf(part);
		}
		return sb.toString();
	}
}