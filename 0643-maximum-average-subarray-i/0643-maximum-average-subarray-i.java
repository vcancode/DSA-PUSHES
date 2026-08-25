class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double avg = 0;

        int left = 0;
        double maxavg =Integer.MIN_VALUE;
        double length = 0;

        for (int i = 0; i < n; i++) {
            avg += nums[i];

            if (i - left + 1 >= k) {
                maxavg = Math.max(maxavg, avg / k);
                avg -= nums[left++];
            }
        }

        return maxavg;
    }
}