class Solution {
    public int minInsertions(String s) {
        int count=0;
        Stack<Character> st = new Stack<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(c=='(') st.push(c);
            else if(i<arr.length-1 && arr[i+1]==')'){
                if(st.isEmpty()) count+=1;
                else st.pop();
                i++;
            }
            else {
                if(!st.isEmpty()){
                        count+=1;
                        st.pop();
                }
                else count+=2;
            }
        }

        count+=(2*st.size());

        return count;
    }
}