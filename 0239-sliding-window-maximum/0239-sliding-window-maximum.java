
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // jitne hijde out of window chale gaye unki chut maardo
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // ab monotonic stack ki tarah karo ... joh new nums hai must be increasing order 
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // last me gaand me daaldo
            dq.offerLast(i);

            //jab window  size par i pahunch jaye toh answer me daalna shur kardo
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
