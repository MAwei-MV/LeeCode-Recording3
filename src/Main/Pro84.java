package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pro84 {
    public static void main(String args[]) {
        Pro84 p = new Pro84();
        int a[] = {2, 1, 6, 5, 2, 3};
        System.out.println(p.largestRectangleArea(a));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int i = 1;
        do {
            if (heights[i] < heights[stack.peek()]) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int temp = stack.pop();
                    int f = -1;
                    if (!stack.isEmpty()) {
                        f = stack.peek();
                    }
                    res = Math.max(res, heights[temp] * (i - f - 1));
                }
            }
            stack.add(i);
            i++;
        } while (i < heights.length);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            int f = -1;
            if (!stack.isEmpty()) {
                f = stack.peek();
            }
            res = Math.max(res, heights[temp] * (i - f - 1));
        }
        return res;
    }
}
