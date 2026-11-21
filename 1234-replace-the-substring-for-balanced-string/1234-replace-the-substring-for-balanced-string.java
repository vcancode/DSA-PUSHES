class Solution {
    public int balancedString(String s) {
        int[] freq = new int[26];

        for(char c :  s.toCharArray()){
            freq[c-'A']++;
        }
        int n= s.length();
        int minlen = n;
        int l=0;
        int target = n/4;
        for(int j=0;j<n;j++){
            char c = s.charAt(j);
            freq[c-'A']--;

            while(l<n && freq['R'-'A']<=target && freq['Q'-'A']<=target && freq['W'-'A']<=target && freq['E'-'A']<=target){
                minlen = Math.min(minlen,j-l+1);
                freq[s.charAt(l)-'A'] ++;
                l++;
            }

        }

            return (minlen==n)?0:minlen;
    }
}