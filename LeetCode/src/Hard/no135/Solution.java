package Hard.no135;

class Solution {
	public int candy(int[] ratings) {

		int[] candies = new int[ratings.length];

		for (int i = 0; i < candies.length; i++) {

			if ((i == 0 || ratings[i - 1] >= ratings[i]) && (i == candies.length - 1 || ratings[i] <= ratings[i + 1])) {
				candies[i] = 1;
			}

		}

		for (int i = 0; i < candies.length - 1; i++) {
			if (ratings[i] < ratings[i + 1])
				candies[i + 1] = Math.max(candies[i] + 1, candies[i + 1]);
		}

		for (int i = candies.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i])
				candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
		}

		int sum = 0;
		for (int candy : candies)
			sum += candy;

		return sum;
	}
}