class Solution {
    public int calculate(String s) {
        int num=0;
        int result=0;
        char op='+';
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<=s.length();i++){
            char c=(i==s.length())?'+':s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c!=' '){
                if(op=='+') st.push(num);
                else if(op=='-') st.push(-num);
                else if(op=='*') st.push(st.pop()*num);
                else if(op=='/') st.push(st.pop()/num);
                op=c;
                num=0;
            }

        }


        while(!st.isEmpty()){
            result+=(st.pop());
        }

        return result;

    }
}