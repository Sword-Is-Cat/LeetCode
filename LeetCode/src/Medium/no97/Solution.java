package Medium.no97;

class Solution {

	String s1, s2, s3;
	Boolean[][] cache;

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length())
			return false;

		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		cache = new Boolean[s1.length() + 1][s2.length() + 1];

		return check(0, 0);
	}

	boolean check(int i1, int i2) {

		if (cache[i1][i2] == null) {
			boolean rst = s1.length() == i1 && s2.length() == i2;
			if (!rst) {
				if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2))
					rst |= check(i1 + 1, i2);
			}
			if (!rst) {
				if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2))
					rst |= check(i1, i2 + 1);
			}
			cache[i1][i2] = rst;
		}

		return cache[i1][i2];
	}
}