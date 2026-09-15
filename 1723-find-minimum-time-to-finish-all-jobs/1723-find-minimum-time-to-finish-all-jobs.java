import java.util.*;

class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {

        Arrays.sort(jobs);

        int n = jobs.length;

        int low = jobs[n - 1];
        int high = 0;

        for (int job : jobs) {
            high += job;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Fresh workers for every check
            int[] workers = new int[k];

            if (canAssign(jobs, n - 1, workers, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canAssign(int[] jobs, int index,
                              int[] workers, int limit) {

        // All jobs assigned
        if (index < 0) {
            return true;
        }

        int job = jobs[index];

        for (int i = 0; i < workers.length; i++) {

            if (workers[i] + job <= limit) {

                workers[i] += job;

                if (canAssign(jobs, index - 1, workers, limit)) {
                    return true;
                }

                // Backtrack
                workers[i] -= job;
            }

            // Empty workers are equivalent
            if (workers[i] == 0) {
                break;
            }
        }

        return false;
    }
}