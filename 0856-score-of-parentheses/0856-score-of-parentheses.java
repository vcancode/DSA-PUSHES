class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push(score);
                score=0;
            }
            else{
                if(s.charAt(i-1)=='('){
                    score = st.pop()+1;
                }
                else{
                    score =st.pop()+2*score;
                }
            } 
        }
        return  score;
    }

        
}
