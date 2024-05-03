package Medium.no165;

class Solution {
	public int compareVersion(String version1, String version2) {

		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int lengthFlag = Integer.compare(arr1.length, arr2.length);
		int minLength = Math.min(arr1.length, arr2.length);

		for (int i = 0; i < minLength; i++) {

			int compared = Integer.compare(Integer.parseInt(arr1[i]), Integer.parseInt(arr2[i]));
			if (compared != 0)
				return compared;
		}

		if (lengthFlag != 0) {

			String[] longerArr = lengthFlag == 1 ? arr1 : arr2;

			for (int i = minLength; i < longerArr.length; i++)
				if (Integer.parseInt(longerArr[i]) > 0)
					return lengthFlag;

		}
		return 0;
	}
}