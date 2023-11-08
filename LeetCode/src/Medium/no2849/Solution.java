package Medium.no2849;

class Solution {
	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
		int mx = Math.abs(fx - sx), my = Math.abs(fy - sy);
		int max = Math.max(mx, my);
		return t == 1 ? max == 1 : max <= t;
	}
}