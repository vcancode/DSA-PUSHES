class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int n = 1;

        while (set.contains(n*k)) {
            n++;
        }

        return n*k;
    }
}