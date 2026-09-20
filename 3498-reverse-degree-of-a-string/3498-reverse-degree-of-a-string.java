class Solution {
    public int reverseDegree(String s) {
        if(s.length()==0) return 0;
        int[] degs=new int[26];
        int ans=0;
        for(int i=0;i<26;i++){
            degs[i]=26-i;
        }

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int  deg=degs[c-'a'];
            ans+=deg*(i+1);
        }

        return ans;
    }
}