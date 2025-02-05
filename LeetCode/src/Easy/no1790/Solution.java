package Easy.no1790;

class Solution {
	public boolean areAlmostEqual(String s1, String s2) {

		if (s1.equals(s2))
			return true;

		char[] arr = s1.toCharArray();
		int e = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != s2.charAt(i)) {
				if (e == -1) {
					e = i;
				} else {
					char temp = arr[i];
					arr[i] = arr[e];
					arr[e] = temp;
					return s2.equals(new String(arr));
				}
			}
		}

		return false;

	}
}