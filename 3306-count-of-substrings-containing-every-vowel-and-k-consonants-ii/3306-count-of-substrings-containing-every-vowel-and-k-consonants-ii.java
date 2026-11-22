
class Solution {

    public long countOfSubstrings(String word, int k) {
        return atMost(word, k) - atMost(word, k - 1);
    }

    private long atMost(String word, int k) {
        if (k < 0) return 0;

        int n = word.length();
        int l = 0;
        int consonants = 0;

        // Last occurrence of each vowel
        int[] lastSeen = {-1, -1, -1, -1, -1};

        long ans = 0;

        for (int r = 0; r < n; r++) {

            char ch = word.charAt(r);

            int idx = getVowelIndex(ch);

            if (idx != -1) {
                lastSeen[idx] = r;
            } else {
                consonants++;
            }

            // Maintain at most k consonants
            while (consonants > k) {
                char leftChar = word.charAt(l);

                if (getVowelIndex(leftChar) == -1) {
                    consonants--;
                }

                l++;
            }

            // Find the earliest last occurrence
            int minLast = Integer.MAX_VALUE;

            for (int pos : lastSeen) {
                minLast = Math.min(minLast, pos);
            }

            // All five vowels must be present
            if (minLast >= l) {
                ans += minLast - l + 1;
            }
        }

        return ans;
    }

    private int getVowelIndex(char ch) {
        switch (ch) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}
