class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i=0,j=0;
        int n = s.length();
        int maxlen=0,maxcount=0;
        while(j<n){
            freq[s.charAt(j)-'A']++;
             maxcount=Math.max(maxcount,freq[s.charAt(j)-'A']);
            while((j-i+1) - maxcount>k){
                freq[s.charAt(i)-'A']--;
                maxcount=Math.max(maxcount,freq[s.charAt(j)-'A']);
                i++;
            }
            maxlen=Math.max(j-i+1,maxlen);
            j++;
        }

        return maxlen;
    }
}