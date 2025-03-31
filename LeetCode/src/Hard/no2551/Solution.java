class Solution {
    public long putMarbles(int[] weights, int k) {

        int[] partSum = new int[weights.length - 1];
        for (int i = 0; i < partSum.length; i++) {
            partSum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(partSum);
        long max = 0, min = 0;

        for (int i = 0; i < k - 1; i++) {
            min += partSum[i];
            max += partSum[partSum.length - 1 - i];
        }

        return max - min;
    }
}