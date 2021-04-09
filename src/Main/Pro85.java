package Main;

import java.util.Arrays;
import java.util.Stack;

public class Pro85 {
    public static void main(String args[]) {
        char a[][] = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Pro85 p = new Pro85();
        System.out.println(p.maximalRectangle(a));
    }

    public int maximalRectangle(char[][] matrix) {
        int tem[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < tem.length; i++) {
            for (int j = 0; j < tem[0].length; j++) {
                if (matrix[i][j] == '0') tem[i][j] = 0;
                else {
                    int m = 1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (matrix[k][j] == '1') m++;
                        else {
                            break;
                        }
                    }
                    tem[i][j] = m;
                }
            }
        }
        int res[] = new int[tem.length];
        for (int i = 0; i < tem.length; i++) {
            res[i] = largestRectangleArea(tem[i]);
        }
        Arrays.sort(res);
        return res[res.length - 1];
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
