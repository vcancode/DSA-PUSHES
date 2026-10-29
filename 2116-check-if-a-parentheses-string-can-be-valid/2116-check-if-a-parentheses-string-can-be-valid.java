class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n<=1 || n%2!=0) return false;
        int open=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='(' || locked.charAt(i)=='0') open++;
            else open--;

            if(open<0) return false;
        }

        open=0;

            for(int i=n-1;i>=0;i--){
                char c=s.charAt(i);
                if(c==')' || locked.charAt(i)=='0'){
                    open++;
                }
                else open--;
                if(open<0) return false;
            }


        return true;
    }
}