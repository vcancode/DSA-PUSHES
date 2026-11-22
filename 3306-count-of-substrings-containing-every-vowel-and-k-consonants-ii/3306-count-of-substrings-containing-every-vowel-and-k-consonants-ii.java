class Solution {
    private int  getvowel(char c){
        switch (c){
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
    public long countOfSubstrings(String word, int k) {
        return atMostK(word,k) - atMostK(word,k-1);
    }

    private long atMostK(String word,int k){
        if(k<0) return 0;
        int l=0,n=word.length();
        long count=0;
        int consonants=0;
        int[] lastseen = {-1,-1,-1,-1,-1};

        for(int r=0;r<n;r++){
            char c = word.charAt(r);
            int idx = getvowel(c);
            if(idx!=-1) lastseen[idx]=r;
            else consonants++;


            while(consonants>k){
                char left = word.charAt(l);
                if(getvowel(left)==-1) consonants--;
                l++;
            }

            int minlast=lastseen[0];
            for(int last:lastseen){
                minlast = Math.min(last,minlast);
            }

            if(minlast>=l) count+=minlast-l+1;
        }

        return count;
    }
}