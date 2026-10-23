class Solution {
    public String minRemoveToMakeValid(String s) {
        int open=0;
        StringBuilder result= new StringBuilder();

        // left to right scan
        for(char c:s.toCharArray()){
            if(c=='(') {
                open++;
                result.append(c);
                }
            else if(c==')'){
                if(open>0){
                    result.append(c);
                    open--;
                }
            }

            else result.append(c);
        }

         // right to left scan if in case open jyada ho gaya
        if(open>0){
                int i=result.length()-1;
                while(i>=0 && open>0){
                    char c=result.charAt(i);
                    if(c=='(') {
                        result.deleteCharAt(i);
                        open--;
                    }
                    i--;
                }
        }

        return result.toString();
    }
}