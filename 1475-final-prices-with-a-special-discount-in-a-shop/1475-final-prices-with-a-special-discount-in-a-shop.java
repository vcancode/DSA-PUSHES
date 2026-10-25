class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] ans = Arrays.copyOf(prices, prices.length);;

        Stack<Integer> st = new Stack();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && prices[st.peek()]>prices[i]) st.pop();
            
            if(!st.isEmpty()){
                ans[i]=prices[i]-prices[st.peek()];
            }
            st.push(i);
        }

        return ans;
    }
}