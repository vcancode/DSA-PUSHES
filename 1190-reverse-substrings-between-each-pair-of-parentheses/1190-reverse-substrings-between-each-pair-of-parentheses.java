class Solution {
    public String reverseParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                st.push(result.length());
            }

            else if (c == ')') {
                int start = st.pop();
                reverse(result, start, result.length() - 1);
            }

            else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }
}