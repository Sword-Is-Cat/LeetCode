package Easy.no38;

class Solution {
	public String countAndSay(int n) {

		return process(n - 1, "1");

	}

	public String process(int n, String str) {

		if (n == 0)
			return str;

		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();

		int count = 0;
		char temp = arr[0];
		
		for(char ch : arr) {
			
			if(temp == ch) {
				count++;
			}else {
				sb.append(count);
				sb.append(temp);
				temp = ch;
				count = 1;
			}
		}
		sb.append(count);
		sb.append(temp);
		
		return process(n-1, sb.toString());
	}
}