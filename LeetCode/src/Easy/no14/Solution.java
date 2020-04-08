package Easy.no14;

class Solution {
	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";
		else if(strs.length == 1)
			return strs[0];
		
		StringBuilder sb = new StringBuilder();
		char[] arr = strs[0].toCharArray();

		breakpoint: for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].indexOf(sb.toString()) != 0)
					break breakpoint;
			}
			if(i==arr.length-1)
				return sb.toString();
		}

		if (sb.length() != 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}