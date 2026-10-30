class Solution {
    public int minimumDeletions(String s) {
        int a=0,b=0,n=s.length();
        for(char c: s.toCharArray()) if(c=='a') a++;

        int ans=Integer.MAX_VALUE;

        for(char c:s.toCharArray()){
            if(c=='a') a--;
            ans=Math.min(ans,a+b);
            if(c=='b') b++;
        }

        return ans;
    }
}