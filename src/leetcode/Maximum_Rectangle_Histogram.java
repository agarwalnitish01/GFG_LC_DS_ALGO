package leetcode;

import java.util.Stack;


public class Maximum_Rectangle_Histogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
        System.out.println(largestRectangleArea2(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] width = new int[n];

        //left smallest element
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) // pop out all greater elements
                stack1.pop();
            if (!stack1.isEmpty())
                left[i] = stack1.peek();
            else
                left[i] = -1;
            stack1.push(i);
        }

        //right smallest element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i])
                stack2.pop();
            if (!stack2.isEmpty())
                right[i] = stack2.peek();
            else
                right[i] = n;
            stack2.push(i);
        }

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        int mxArea = 0;
        for (int i = 0; i < n; i++) {
            mxArea = Math.max(mxArea, width[i] * heights[i]);
        }
        return mxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int last = heights[stack.pop()];
                int width = last * (stack.isEmpty() ? i : i - stack.peek() - 1);
                area = Math.max(area, width);
            }
            stack.push(i);
        }
        return area;
    }
}
