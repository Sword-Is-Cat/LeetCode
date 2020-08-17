package Challenge.August3rd_2;

class Solution {
	public int[] distributeCandies(int candies, int num_people) {

		int[] arr = new int[num_people];

		int no = 1;

		while (candies > 0) {
			arr[(no - 1) % num_people] += Math.min(candies, no);
			candies -= Math.min(candies, no);
			no++;
		}

		return arr;

	}
}