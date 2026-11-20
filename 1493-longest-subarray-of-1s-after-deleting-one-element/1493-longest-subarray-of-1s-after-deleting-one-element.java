class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int zeroes=0;
        int n=nums.length;
        int ans=0;
        while(j<n){
            if(nums[j]==0) zeroes++;
            while(zeroes>1){
                if(nums[i]==0) zeroes--;
                i++;
            }

            ans=Math.max(j-i,ans);
            j++;

        }

        return ans;
    }
}