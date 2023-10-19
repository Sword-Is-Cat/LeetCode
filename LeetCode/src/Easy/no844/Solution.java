package Easy.no844;

class Solution {
	public boolean backspaceCompare(String s, String t) {

		int si = s.length() - 1, ti = t.length() - 1;

		while (0 <= si && 0 <= ti) {
			si = findNextIndex(s, si, 0);
			ti = findNextIndex(t, ti, 0);
			if (0 <= si && 0 <= ti) {
				if (s.charAt(si) == t.charAt(ti)) {
					si--;
					ti--;
				} else
					return false;
			}
		}

		si = findNextIndex(s, si, 0);
		ti = findNextIndex(t, ti, 0);

		return si == ti;
	}

	private int findNextIndex(String str, int index, int erase) {
		if (index < 0)
			return -1;
		if (str.charAt(index) == '#')
			return findNextIndex(str, index - 1, erase + 1);
		if (erase > 0)
			return findNextIndex(str, index - 1, erase - 1);
		return index;
	}
}