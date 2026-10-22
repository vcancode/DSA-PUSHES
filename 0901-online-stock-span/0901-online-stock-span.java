class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        int[] arr = new int[2];
        if(st.isEmpty()){
            arr[0]=price;
            arr[1]=count;
            st.push(arr);
        }
        else{
            while(!st.isEmpty() && st.peek()[0]<=price){
               count+=st.peek()[1];
               st.pop();
            }
            arr[0]=price;
            arr[1]=count;
            st.push(arr);
        }
        return count;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */