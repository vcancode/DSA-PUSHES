class Solution {

    private void helper(int[] nums,
                        List<List<Integer>> ans,
                        int idx) {

        if (idx == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            ans.add(permutation);
            return;
        }

        // Values already tried for this position
        Set<Integer> st = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {

            int chosen = nums[i];

            // Don't make the same choice twice at this level
            if (st.contains(chosen)) {
                continue;
            }

            st.add(chosen);

            // swap
            int temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp;

            // recursive call
            helper(nums, ans, idx + 1);

            // backtrack
            temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, 0);
        return ans;
    }
}