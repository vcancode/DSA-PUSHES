import java.util.*;

class Solution {

    public int longestSubarray(int[] nums, int k) {

        int n = nums.length;

        // Find maximum element
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Smallest Prime Factor
        int[] spf = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= max; i++) {

            if (spf[i] == i) {

                for (int j = i * i; j <= max; j += i) {

                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        // cnt[p] = number of elements in current
        // window having prime factor p
        int[] cnt = new int[max + 1];

        int distinct = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            int x = nums[right];

            // Add nums[right]
            while (x > 1) {

                int p = spf[x];

                if (cnt[p] == 0) {
                    distinct++;
                }

                cnt[p]++;

                // Remove all occurrences of p
                while (x % p == 0) {
                    x /= p;
                }
            }

            // Shrink window if there are more than k
            // distinct prime factors
            while (distinct > k) {

                x = nums[left];

                // Remove nums[left]
                while (x > 1) {

                    int p = spf[x];

                    cnt[p]--;

                    if (cnt[p] == 0) {
                        distinct--;
                    }

                    // Remove all occurrences of p
                    while (x % p == 0) {
                        x /= p;
                    }
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}