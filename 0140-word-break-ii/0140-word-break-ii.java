class Solution {

    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        set.addAll(wordDict);

        helper(s, 0, new StringBuilder());

        return ans;
    }

    private void helper(String s, int index, StringBuilder current) {

        // Entire string has been used
        if (index == s.length()) {
            ans.add(current.toString().trim());
            return;
        }

        int startLength = current.length();

        // Try every possible substring
        for (int i = index; i < s.length(); i++) {

            String word = s.substring(index, i + 1);

            // Only continue if it is a dictionary word
            if (!set.contains(word)) {
                continue;
            }

            // Choose
            current.append(word).append(" ");

            // Recurse
            helper(s, i + 1, current);

            // Undo
            current.setLength(startLength);
        }
    }
}