package Easy.no709;

class Solution {
	public String toLowerCase(String s) {

		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) 
			if (64 < arr[i] && arr[i] < 91)
				arr[i] += 32;
		
		return new String(arr);
	}
}