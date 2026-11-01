
import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            // Update histogram heights
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate largest rectangle
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() &&
                   heights[st.peek()] >= currHeight) {

                int index = st.pop();

                int height = heights[index];

                int pse = st.isEmpty() ? -1 : st.peek();

                int nse = i;

                int width = nse - pse - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                st.push(i);
            }
        }

        return maxArea;
    }
}
