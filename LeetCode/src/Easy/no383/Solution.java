package Easy.no383;

class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {

		char[] rArr = ransomNote.toCharArray();
		char[] mArr = magazine.toCharArray();

		boolean answer = true;

		for (int i = 0; i < rArr.length; i++) {
			
			boolean flag = true;
			
			for (int j = 0; j < mArr.length; j++) {
				
				if (rArr[i] == mArr[j]) {
					
					mArr[j] = ' ';
					flag = false;
					break;
				}
			}
			
			if (flag) {
				
				answer = false;
				break;
			}
		}
		
		return answer;
	}
}