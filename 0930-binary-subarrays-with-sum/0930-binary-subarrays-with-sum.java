class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0,sum=0;
        int i=0,j=0;
        int n=nums.length;
        int zeroes=0;
        while(j<n){
            sum+=nums[j];

            while(i<j && (sum>goal || nums[i]==0))
            {
                if(nums[i]==0) zeroes++;
                else zeroes=0;
                sum-=nums[i];
                i++;
            }

            if(sum==goal){
                count+=(1+zeroes);
            }

            j++;
        }

        return count ;
    }
}