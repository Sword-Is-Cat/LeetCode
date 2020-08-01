package Easy.no482;

class Solution {
	public String licenseKeyFormatting(String S, int K) {

		char[] arr = S.toUpperCase().replaceAll("-", "").toCharArray();
		StringBuilder sb = new StringBuilder();

		System.out.println(arr.length%K);
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if ((i + 1) % K == arr.length % K && i + 1 != arr.length)
				sb.append('-');
		}

		return sb.toString();
	}
}