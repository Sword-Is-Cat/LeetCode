package Easy.no125;

class Solution {
	public boolean isPalindrome(String s) {

		s = s.toLowerCase().replaceAll("[^0-9a-z]", "");

		String r = new StringBuilder(s).reverse().toString();

		return r.equals(s);

	}
}