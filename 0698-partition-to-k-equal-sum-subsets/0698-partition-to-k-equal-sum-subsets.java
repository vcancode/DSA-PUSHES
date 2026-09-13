class Solution {
    private boolean helper(int[] nums, int idx,int[] bucket,int target){
        if(idx<0) return true;
        int num=nums[idx];
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]+num>target) continue;

            bucket[i]+=num;
            if(helper(nums,idx-1,bucket,target)) return true;

            bucket[i]-=num;

            if(bucket[i]==0) break;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        int n=nums.length;
        for(int num:nums) total+=num;
        if(total%k!=0) return false;
        int target=total/k;
        Arrays.sort(nums);
        int[] bucket = new int[k];
        return helper(nums,n-1,bucket,target);
    }
}