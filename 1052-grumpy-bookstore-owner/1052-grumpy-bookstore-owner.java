class Solution {
    public int maxSatisfied(int[] c, int[] g, int m) {
        int n = c.length;

        int startidx = 0;
        int endidx = m - 1;

        int i = 0;
        int j = endidx;

        int maxsum = 0;
        int sum = 0;

        for (int p = startidx; p <= endidx; p++) {
            if (g[p] == 1) {
                sum += c[p];
            }
        }


        maxsum = sum;

        while (endidx < n - 1) {

            if (g[startidx] == 1) {
                sum -= c[startidx];
            }

            if (g[endidx + 1] == 1) {
                sum += c[endidx + 1];
            }

            startidx++;
            endidx++;

            if (sum > maxsum) {
                maxsum = sum;
                i = startidx;
                j = endidx;
            }
        }


        sum = 0;

        for (int k = 0; k < n; k++) {


            if (k >= i && k <= j) {
                sum += c[k];
            }

            else if (g[k] == 0) {
                sum += c[k];
            }
        }

        return sum;
    }
}