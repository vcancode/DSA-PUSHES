class Solution {
    public int minOperations(int[] nums, int x) {
        int i=0,j=0;
        int n = nums.length;
        int total = 0;
        for(int y: nums){
            total+=y;
        }

        int check =0;
        int target = total-x;
        int  sum=0;
        int len =0;
        
        while(j<n){
            sum+=nums[j];
            while(i<=j && sum>target){
                sum-=nums[i];
                i++;
            }
            if(sum==target){
                check = 1;
                len = Math.max(len,j-i+1);
            }

            j++;
        }

        if(check==0) return -1;
        return n-len;
    }
}