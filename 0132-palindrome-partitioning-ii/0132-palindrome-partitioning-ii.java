class Solution {

    int[] dp;

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }

    private int solve(String s, int idx){
        if(idx==s.length()) return -1;

        if(dp[idx]!=-1) return dp[idx];
        int ans = Integer.MAX_VALUE;

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                int cuts = 1 + solve(s,i+1);
                ans=Math.min(ans,cuts);
            }
        }

        dp[idx]=ans;

        return ans;
    }
}