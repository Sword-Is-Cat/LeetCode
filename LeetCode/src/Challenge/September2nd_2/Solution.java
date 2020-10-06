package Challenge.September2nd_2;

class Solution {
	public int compareVersion(String version1, String version2) {

		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		
		int length = 0;

		if (arr1.length > arr2.length)
			length = 1;
		else if (arr1.length < arr2.length)
			length = -1;

		int minLength = Math.min(arr1.length, arr2.length);
		
		for (int i = 0; i < minLength; i++) {
			if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
				return 1;
			else if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]))
				return -1;
		}
		
		if (length == 1) {
			for (int i = minLength; i < arr1.length; i++)
				if (Integer.parseInt(arr1[i]) > 0)
					return length;
		} else if (length == -1) {
			for (int i = minLength; i < arr2.length; i++)
				if (Integer.parseInt(arr2[i]) > 0)
					return length;
		}

		return 0;
	}
}