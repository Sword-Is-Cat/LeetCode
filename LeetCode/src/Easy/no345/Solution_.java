package Easy.no345;

class Solution_ {
	public String reverseVowels(String s) {

		char[] arr = s.toCharArray();

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (checkVowel(arr[i]) && checkVowel(arr[j])) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			} else {
				while (i < arr.length && !checkVowel(arr[i]))
					i++;
				while (j >= 0 && !checkVowel(arr[j]))
					j--;
			}
		}

		return new String(arr);

	}

	public boolean checkVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U')
			return true;
		else
			return false;
	}
}