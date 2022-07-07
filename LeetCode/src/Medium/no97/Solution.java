package Medium.no97;

class Solution {

	char[] s1, s2, s3;
	Boolean[][][] cache;

	public boolean isInterleave(String s1, String s2, String s3) {

		this.s1 = s1.toCharArray();
		this.s2 = s2.toCharArray();
		this.s3 = s3.toCharArray();
		cache = new Boolean[this.s1.length + 1][this.s2.length + 1][this.s3.length + 1];

		return check(0, 0, 0);
	}

	boolean check(int i1, int i2, int i3) {

		if (cache[i1][i2][i3] == null) {

			boolean rst = s1.length == i1 && s2.length == i2 && s3.length == i3;

			if (!rst) {
				if (i1 < s1.length && i3 < s3.length && s1[i1] == s3[i3])
					rst |= check(i1 + 1, i2, i3 + 1);
			}

			if (!rst) {
				if (i2 < s2.length && i3 < s3.length && s2[i2] == s3[i3])
					rst |= check(i1, i2 + 1, i3 + 1);
			}

			cache[i1][i2][i3] = rst;

		}

		return cache[i1][i2][i3];
	}
}