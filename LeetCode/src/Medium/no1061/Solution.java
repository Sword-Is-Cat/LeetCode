package Medium.no1061;

class Solution {

	private static final char a = 'a';

	public String smallestEquivalentString(String s1, String s2, String baseStr) {

		UnionFind uf = new UnionFind(26);
		for (int i = 0; i < s1.length(); i++)
			uf.set(s1.charAt(i) - a, s2.charAt(i) - a);

		char[] baseArr = baseStr.toCharArray();
		for (int i = 0; i < baseArr.length; i++)
			baseArr[i] = (char) (uf.get(baseArr[i] - a) + a);

		return new String(baseArr);
	}
}

class UnionFind {

	int[] uf;

	UnionFind(int length) {
		uf = new int[length];
		for (int i = 0; i < length; i++)
			uf[i] = i;
	}

	public void set(int a, int b) {
		a = get(a);
		b = get(b);
		uf[Math.max(a, b)] = Math.min(a, b);
	}

	public int get(int a) {
		int rst = uf[a];
		if (rst != a)
			uf[a] = get(rst);
		return uf[a];
	}

}