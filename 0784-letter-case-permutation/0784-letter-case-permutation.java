class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        
        backtrack(s.toCharArray(), 0, result);
        
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {
        // We have processed the entire string
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // If current character is a letter
        if (Character.isLetter(chars[index])) {

            // Choice 1: lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);

            // Choice 2: uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);

        } else {
            // Digit: only one possibility
            backtrack(chars, index + 1, result);
        }
    }
}