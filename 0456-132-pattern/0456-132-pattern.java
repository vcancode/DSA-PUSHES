class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int nums3=Integer.MIN_VALUE,nums2;
        Stack<Integer> st = new  Stack<>();
        for(int i=n-1;i>=0;i--){
            if(nums[i]<nums3) return true;

            while(!st.isEmpty() && nums[i]>st.peek()) nums3=st.pop();

            st.push(nums[i]);
            
        }

        return false;
    }
}