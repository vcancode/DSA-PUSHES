class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        // Calculate array sum
        long arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }

        // If target is a multiple of arrSum
        if (target % arrSum == 0) {
            return (int)((target / arrSum) * n);
        }

        // If target > arrSum, we need complete arrays + partial subarray
        if (target > arrSum) {
            count = (int)((target / arrSum) * n);
            target %= arrSum;
        }

        // Sliding window on circular array
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        long currSum = 0;

        while (r < 2 * n) {
            currSum += nums[r % n];

            // Shrink left boundary
            while (l <= r && currSum > target) {
                currSum -= nums[l % n];
                l++;
            }

            // Update answer
            if (currSum == target) {
                ans = Math.min(ans, r - l + 1);
            }

            r++;
        }

        return ans == Integer.MAX_VALUE ? -1 : count + ans;
    }
}