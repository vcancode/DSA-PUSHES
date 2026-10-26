class Solution {
    public int calculate(String s) {
        int n = s.length();
        if (s.length() == 0)
            return 0;
        int sign = 1;
        int result = 0;
        int number = 0;
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += number * sign;
                number = 0;
                if(c=='+') sign=1;
                else sign=-1;
            } else if (c == '(') {
                res.push(result);
                result = 0;
                res.push(sign);
                sign=1;
            } else if(c==')') {
                result+=number*sign;
                int sgn = res.pop();
                int prevresult=res.pop();
                result = prevresult + (sgn*result);
                number=0;
            }

        }

        result+=number*sign;

        return result;
    }
}

