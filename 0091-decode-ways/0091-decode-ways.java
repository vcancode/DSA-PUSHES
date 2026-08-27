class Solution {
    public int numDecodings(String s) {
        Integer[] mem=new Integer[s.length()];
        return s.length() == 0 ? 0 : helper(s, 0,mem);
    }

    private int helper(String s, int idx,Integer[] mem) {
        int n = s.length();

        if (idx == n) {
            return 1;
        }

        // A number cannot start with 0
        if (s.charAt(idx) == '0') {
            return 0;
        }

        if(mem[idx]!=null) return mem[idx];

        // Take one digit
        int res = helper(s, idx + 1,mem);

        // Take two digits
        if (idx < n - 1 &&
            (s.charAt(idx) == '1' ||
             (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))) {

            res += helper(s, idx + 2,mem);
        }

        return mem[idx]=res;
    }
}