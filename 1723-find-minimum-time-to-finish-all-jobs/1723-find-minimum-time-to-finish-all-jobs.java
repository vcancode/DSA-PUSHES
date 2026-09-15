class Solution {

    int ans = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {

        // 1. Largest jobs first
        Arrays.sort(jobs);
        reverse(jobs);

        int[] workers = new int[k];

        backtrack(jobs, 0, workers);

        return ans;
    }

    void backtrack(int[] jobs, int idx, int[] workers) {

        // All jobs assigned
        if (idx == jobs.length) {

            int max = 0;

            for (int time : workers) {
                max = Math.max(max, time);
            }

            ans = Math.min(ans, max);

            return;
        }

        int job = jobs[idx];

        for (int i = 0; i < workers.length; i++) {

            // 2. Branch pruning
            if (workers[i] + job >= ans) {
                continue;
            }

            // Choose
            workers[i] += job;

            // Explore
            backtrack(jobs, idx + 1, workers);

            // Undo
            workers[i] -= job;

            // 3. Symmetry pruning
            if (workers[i] == 0) {
                break;
            }
        }
    }

    void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}