class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[t.length];
        for(int i=t.length-1;i>=0;i--){
            int curr=t[i];
            while(!st.isEmpty() && t[st.peek()]<=curr) st.pop();

            if(!st.isEmpty()) ans[i]=st.peek()-i;

            st.push(i);
            
        }

        return ans;
    }
}