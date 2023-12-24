package Easy.no1496;

import java.util.HashSet;

class Solution {
	public boolean isPathCrossing(String path) {

		int countH = 0, countV = 0;
		HashSet<Coord> set = new HashSet<>();
		set.add(new Coord(0, 0));

		for (char ch : path.toCharArray()) {
			switch (ch) {
			case 'N':
				countH++;
				break;
			case 'S':
				countH--;
				break;
			case 'E':
				countV++;
				break;
			case 'W':
				countV--;
				break;
			}
			if (!set.add(new Coord(countH, countV)))
				return true;
		}
		return false;
	}
}

class Coord {
	int ver, hor;

	public Coord(int ver, int hor) {
		this.ver = ver;
		this.hor = hor;
	}

	@Override
	public int hashCode() {
		return this.ver + this.hor;
	}

	@Override
	public boolean equals(Object obj) {
		Coord target = obj instanceof Coord ? (Coord) obj : null;
		return target != null && target.ver == this.ver && target.hor == this.hor;
	}
}