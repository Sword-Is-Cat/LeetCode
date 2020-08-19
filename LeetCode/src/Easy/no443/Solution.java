package Easy.no443;

class Solution {
	public int compress(char[] chars) {

		char last = chars[0];
		int count = 0;
		int answer = 0;

		int index = 0;
		
		for (char ch : chars) {

			if (last == ch)
				count++;
			else {
				
				chars[index++] = last;
				last = ch;

				if (count == 1) {
					answer += 1;
				}else if (count < 10) {
					chars[index++] = (char)(count+48);
					answer += 2;
				}else if (count < 100) {
					chars[index++] = (char)((count/10)+48);
					chars[index++] = (char)((count%10)+48);
					answer += 3;
				}else if (count < 1000) {
					chars[index++] = (char)((count/100)+48);
					chars[index++] = (char)((count/10%10)+48);
					chars[index++] = (char)((count%10)+48);
					answer += 4;
				}else {
					chars[index++] = '1';
					chars[index++] = '0';
					chars[index++] = '0';
					chars[index++] = '0';
					answer += 5;
				}
				
				count = 1;
			}
		}
		
		chars[index++] = last;

		if (count == 1) {
			answer += 1;
		}else if (count < 10) {
			chars[index++] = (char)(count+48);
			answer += 2;
		}else if (count < 100) {
			chars[index++] = (char)((count/10)+48);
			chars[index++] = (char)((count%10)+48);
			answer += 3;
		}else if (count < 1000) {
			chars[index++] = (char)((count/100)+48);
			chars[index++] = (char)((count/10%10)+48);
			chars[index++] = (char)((count%10)+48);
			answer += 4;
		}else {
			chars[index++] = '1';
			chars[index++] = '0';
			chars[index++] = '0';
			chars[index++] = '0';
			answer += 5;
		}
		return answer;
	}
}