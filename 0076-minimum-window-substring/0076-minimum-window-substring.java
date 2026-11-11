class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length()<t.length()) return "";

        int n= s.length();
        int  m=t.length();

        int l=0,r=0;
        int len=Integer.MAX_VALUE;

        int[] hash = new int[256];
        int count=0;
        int idx=-1;


         for(char c:t.toCharArray()){
            hash[c]++;
        }

        while(r<n){
            if(hash[s.charAt(r)]>0) count++;

            hash[s.charAt(r)]--;

            while(count==m && l<=r){
                if(r-l+1<len){
                    idx=l;
                    len=r-l+1;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) count--;
                l++;
                
            }
            r++;
        }

        if(idx==-1) return "";
        return s.substring(idx,idx+len);

    }
}