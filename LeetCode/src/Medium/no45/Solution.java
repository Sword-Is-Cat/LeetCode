package Medium.no45;

class Solution {
	
	public int jump(int[] nums) {
		
		int jump = 0, next = 0, temp = 0;
		
		for (int point = 0; point < nums.length; point++) {
			
			if (next < point) {
				next = temp;
				jump++;
			}
			temp = Math.max(temp, nums[point] + point);
		}
		return jump;
	}
}