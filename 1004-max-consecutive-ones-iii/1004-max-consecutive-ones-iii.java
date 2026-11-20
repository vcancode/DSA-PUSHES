class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxlen=0,zero=0;
        while(j<nums.length){
                if(nums[j]==0) zero++;
                while(zero>k){
                    if(nums[i]==0) zero--;
                    i++;
                }
                if(zero<=k){
                    maxlen=Math.max(maxlen,j-i+1);
                }
                j++;
        }
        return maxlen;
    }
}