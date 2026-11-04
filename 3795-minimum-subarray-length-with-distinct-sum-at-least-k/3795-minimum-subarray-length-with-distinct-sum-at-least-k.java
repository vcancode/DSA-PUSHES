class Solution {
    public int minLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {

            int num = nums[j];

            if (!map.containsKey(num)) {
                sum += num;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
            while (sum >= k) {

                ans = Math.min(ans, j - i + 1);

                int left = nums[i];

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                    sum -= left;
                }

                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}