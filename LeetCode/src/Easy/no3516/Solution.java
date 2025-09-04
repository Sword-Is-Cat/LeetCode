package Easy.no3516;

class Solution {
	public int findClosest(int x, int y, int z) {
		int dist1 = Math.abs(x - z), dist2 = Math.abs(y - z);
		return dist1 == dist2 ? 0 : dist1 < dist2 ? 1 : 2;
	}
}