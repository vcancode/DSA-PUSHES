
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] >= currHeight) {

                int index = st.pop(); // isse pehle kon bada tha isse woh nikalo 

                int height = heights[index]; // woh bande ke liye calculate karenge

                int pse = st.isEmpty() ? -1 : st.peek(); // uska previous st.peek()

                int nse = i; // abhi joh banda hai wahi uska nse hai 

                int width = nse - pse - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        return maxArea;
    }
}
