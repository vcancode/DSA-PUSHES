class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(st.isEmpty() || st.peek()!=c) st.push(c);
            else if(st.peek()==c) st.pop();
        }

        while(!st.isEmpty()){
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
}