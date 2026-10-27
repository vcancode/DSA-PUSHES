class Solution {
    public int calculate(String s) {
        int num=0;
        int result=0;
        char sign='+';
        Stack<Integer> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c!=' '){
                if(sign=='+') st.push(num);
                if(sign=='-') st.push(-num);
                if(sign=='*') st.push(st.pop()*num);
                if(sign=='/') st.push(st.pop()/num);
                sign=c;
                num=0;
            }

        }

         if(sign=='+') st.push(num);
         if(sign=='-') st.push(-num);
         if(sign=='*') st.push(st.pop()*num);
         if(sign=='/') st.push(st.pop()/num);
         num=0;


        while(!st.isEmpty()){
            result+=(st.pop());
        }

        return result;

    }
}