package Hard.no689;

class Solution {

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

		int currIdx0 = 1, currIdx1 = k + 1, currIdx2 = k * 2 + 1;
		int currSum0 = 0, currSum1 = 0, currSum2 = 0;

		for (int i = 0; i < k * 3; i++) {
			if (i < k)
				currSum0 += nums[i];
			else if (i < k * 2)
				currSum1 += nums[i];
			else
				currSum2 += nums[i];
		}

		int[] bestIdx0 = { 0 }, bestIdx1 = { 0, k }, bestIdx2 = { 0, k, k * 2 };
		int bestSum0 = currSum0, bestSum1 = bestSum0 + currSum1, bestSum2 = bestSum1 + currSum2;

		while (currIdx2 <= nums.length - k) {

			currSum0 += nums[currIdx0 + k - 1] - nums[currIdx0 - 1];
			currSum1 += nums[currIdx1 + k - 1] - nums[currIdx1 - 1];
			currSum2 += nums[currIdx2 + k - 1] - nums[currIdx2 - 1];

			if (currSum0 > bestSum0) {
				bestSum0 = currSum0;
				bestIdx0[0] = currIdx0;
			}

			if (bestSum0 + currSum1 > bestSum1) {
				bestSum1 = bestSum0 + currSum1;
				bestIdx1[0] = bestIdx0[0];
				bestIdx1[1] = currIdx1;
			}

			if (bestSum1 + currSum2 > bestSum2) {
				bestSum2 = bestSum1 + currSum2;
				bestIdx2[0] = bestIdx1[0];
				bestIdx2[1] = bestIdx1[1];
				bestIdx2[2] = currIdx2;
			}

			currIdx0++;
			currIdx1++;
			currIdx2++;

		}

		return bestIdx2;
	}
}