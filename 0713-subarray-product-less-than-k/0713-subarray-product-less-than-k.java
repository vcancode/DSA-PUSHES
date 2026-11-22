class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0,j=0,n=nums.length;
        int product = 1;
        int count=0;
        for(j=0;j<n;j++){
            product*=nums[j];
            while(i<j && product>=k){
                product/=nums[i];
                i++;
            }
            if(product<k){
                count+=(j-i+1);
            }
        }

        return count;
    }
}