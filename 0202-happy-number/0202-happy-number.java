import java.util.HashSet;
import java.util.Set;

class Solution {

    int HS(int n) {
        int sum = 0;

        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (true) {
            int happySum = HS(n);

            if (happySum == 1) {
                return true;
            }

            if (seen.contains(happySum)) {
                return false;
            }

            seen.add(happySum);
            n = happySum;
        }
    }
}