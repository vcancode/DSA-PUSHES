class Solution {
    public long countSubarrays(int[] nums, int k) {
        int l=0,n =  nums.length;
        int max = Integer.MIN_VALUE;
        long ans=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int maxcount =0;

        for(int  r =0;r<n;r++){
            if(nums[r]==max) maxcount++;
            while(maxcount>=k){
                if(nums[l]==max) maxcount--;
                l++;
            }
            ans+=l;
            
        }

        return ans;
    }
}