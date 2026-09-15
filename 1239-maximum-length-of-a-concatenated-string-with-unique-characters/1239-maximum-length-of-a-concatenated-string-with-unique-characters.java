class Solution {

    int ans = 0;

    public int maxLength(List<String> arr) {
        boolean[] used = new boolean[26];

        backtrack(arr, 0, used, 0);

        return ans;
    }

    private void backtrack(
        List<String> arr,
        int idx,
        boolean[] used,
        int length
    ) {

        ans = Math.max(ans, length);

        if (idx == arr.size()) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {

            String s = arr.get(i);

            if (!canTake(s, used)) {
                continue;
            }

            // TAKE
            add(s, used);

            backtrack(
                arr,
                i + 1,
                used,
                length + s.length()
            );

            // UNDO
            remove(s, used);
        }
    }

    private boolean canTake(String s, boolean[] used) {

        boolean[] current = new boolean[26];

        for (char c : s.toCharArray()) {

            int idx = c - 'a';

            if (used[idx] || current[idx]) {
                return false;
            }

            current[idx] = true;
        }

        return true;
    }

    private void add(String s, boolean[] used) {

        for (char c : s.toCharArray()) {
            used[c - 'a'] = true;
        }
    }

    private void remove(String s, boolean[] used) {

        for (char c : s.toCharArray()) {
            used[c - 'a'] = false;
        }
    }
}