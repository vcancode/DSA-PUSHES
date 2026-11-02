class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        int curNum = 0;
        StringBuilder curString = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == '[') {
                st.push(curString.toString());
                st.push(String.valueOf(curNum));

                curString = new StringBuilder();
                curNum = 0;
            }

            else if (c == ']') {
                int num = Integer.parseInt(st.pop());
                String prevString = st.pop();

                StringBuilder temp = new StringBuilder();

                for (int i = 0; i < num; i++) {
                    temp.append(curString);
                }

                curString = new StringBuilder(prevString + temp);
            }

            else if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            }

            else {
                curString.append(c);
            }
        }

        return curString.toString();
    }
}
