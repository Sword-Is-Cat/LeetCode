package Easy.no1089;

class Solution {
	public void duplicateZeros(int[] arr) {

		int[] temp = new int[arr.length];

		int i = 0;

		for (int no : arr) {

			if (i == arr.length) break;

			temp[i++] = no;
			
			if (i == arr.length) break;
			
			if (no == 0)
				temp[i++] = 0;

		}
		
		for(int j = 0 ; j<arr.length ; j++) {
			arr[j] = temp[j];
		}

	}
}