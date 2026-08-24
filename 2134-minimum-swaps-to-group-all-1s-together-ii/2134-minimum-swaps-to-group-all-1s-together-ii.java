class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        }
        
        if (totalOnes == 0 || totalOnes == nums.length) {
            return 0;
        }
        
        int n = nums.length;
        int currentOnes = 0;
        
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }
        
        int maxOnes = currentOnes;
        for (int i = 0; i < n; i++) {
            currentOnes -= nums[i];
            currentOnes += nums[(i + totalOnes) % n]; //** imp line we are %ing the idx so it circles back to 0 */
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        
        return totalOnes - maxOnes;
    }
}