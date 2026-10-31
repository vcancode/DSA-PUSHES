class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int ans=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()) st.push(i);
            else if(nums[st.peek()]>nums[i]) st.push(i);
        }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) ans=Math.max(ans,i-st.pop());

            if(st.isEmpty()) return ans;
        }
        return ans;
        
    }
}