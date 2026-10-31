class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int ans=0;
        int[] rightmax=new int[n];
        rightmax[n-1]=nums[n-1];
        for(int  i=n-2;i>=0;i--){
              rightmax[i]=Math.max(rightmax[i+1],nums[i]);
        }

        int i=0,j=0;
        while(j<n){
            while(i<j && nums[i]>rightmax[j]) i++;
            
            ans=Math.max(j-i,ans);
            j++;
        }

        return ans;
        
    }
}