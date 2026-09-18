class Solution {

    private int helper(int[] nums, int target, int sum, int[] dp) {

        if (sum == target) {
            return 1;
        }

        if (sum > target) {
            return 0;
        }

        if (dp[sum] != -1) {
            return dp[sum];
        }

        int count = 0;

        for (int num : nums) {
            count += helper(nums, target, sum + num, dp);
        }

        return dp[sum] = count;
    }

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return helper(nums, target, 0, dp);
    }
}