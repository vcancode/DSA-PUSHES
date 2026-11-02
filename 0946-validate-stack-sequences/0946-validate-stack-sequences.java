class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int  i=0,j=0;
        int n=pushed.length;
        Stack<Integer> st = new Stack<>();
        while(i<n && j<n){
            st.push(pushed[i]);

            while(!st.isEmpty() && j<n && st.peek()==popped[j]){
                st.pop();
                j++;
            }

            i++;
        }

        return st.isEmpty();
    }
}