class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int  i=0,j=0;
        int n=pushed.length;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            if(st.isEmpty()) st.push(pushed[i++]);
            else{
                if(st.peek()==popped[j]){
                    st.pop();
                    j++;
                }
                else{
                    st.push(pushed[i]);
                    i++;
                }
            }
        }

        while(j<n && st.peek()==popped[j]) {
            st.pop();
            j++;
        }
        
        if(j<n) return false;

        return true;
    }
}