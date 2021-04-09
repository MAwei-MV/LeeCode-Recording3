package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pro989 {
    public static void main(String args[]) {
        Pro989 p = new Pro989();
        int A[] = {0};
        int K = 23;
        p.addToArrayForm(A, K);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        Stack<Integer> s = new Stack<>();
        int i = len - 1;
        int a = 0;//判断是否进位
        while (i >= 0 && K > 0) {
            int j = K % 10;
            int[] temp = helper(A[i] + j + a);
            a = temp[0];
            s.add(temp[1]);
            K /= 10;
            i--;
        }
        while (i >= 0) {
            int temp[] = helper(A[i] + a);
            s.add(temp[1]);
            a = temp[0];
            i--;
        }
        while (K > 0) {
            int temp[] = helper(K%10 + a);
            s.add(temp[1]);
            a = temp[0];
            K /= 10;
        }
        if (a == 1) s.add(1);
        List<Integer> res = new ArrayList<>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }

    private int[] helper(int flag) {
        if (flag >= 10) {
            return new int[]{1, flag - 10};
        } else {
            return new int[]{0, flag};
        }
    }
}
