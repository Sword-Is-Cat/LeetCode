package Challenge.August2nd_4;

class CombinationIterator {

	char[] chArr;
	int[] arr;
	int length;
	boolean next;

	public CombinationIterator(String characters, int combinationLength) {

		chArr = characters.toCharArray();
		arr = new int[chArr.length];
		length = combinationLength;
		next = length == 0 ? false : true;

		for (int i = 0; i < length; i++)
			arr[i] = 1;

	}

	public String next() {

		StringBuilder sb = new StringBuilder();

		if (!next)
			return sb.toString();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				sb.append(chArr[i]);
		}

		for (int i = 1; i <= length; i++) {
			if (arr[arr.length - i] == 0)
				break;
			if (i == length)
				next = false;
		}

		if (next) {

			boolean swap = arr[arr.length - 1] == 1 ? true : false;

			if (swap) {

				int count1 = 0;
				boolean meet0 = false;

				for (int i = 1; i <= arr.length; i++) {

					if (arr[arr.length - i] == 0)
						meet0 = true;
					else if (arr[arr.length - i] == 1 && !meet0) {
						count1++;
						arr[arr.length - i] = 0;
					} else {
						count1++;
						arr[arr.length - i] = 0;
						for (int j = 1; j <= count1; j++)
							arr[arr.length - i + j] = 1;
						break;
					}
				}

			} else {

				for (int i = 1; i <= arr.length; i++) {
					if (arr[arr.length - i] == 1) {
						arr[arr.length - i] = 0;
						arr[arr.length - i + 1] = 1;
						break;
					}
				}
			}
		}

		return sb.toString();

	}

	public boolean hasNext() {

		return next;

	}
}