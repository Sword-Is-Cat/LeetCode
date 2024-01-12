package Easy.no1704;

class Solution_ {
	public boolean halvesAreAlike(String s) {

		char[] arr = s.toLowerCase().toCharArray();
		int length = arr.length, cnt = 0;

		for (int i = 0; i < length; i++) {
			switch (arr[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				if (i < length / 2)
					cnt++;
				else
					cnt--;
			}
		}
		return cnt == 0;
	}
}