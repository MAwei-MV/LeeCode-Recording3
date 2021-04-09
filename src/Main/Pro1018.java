package Main;

import java.util.ArrayList;
import java.util.List;

public class Pro1018 {
    public static void main(String args[]) {
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A.length == 0) return res;
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            flag = 2 * flag + A[i];
            int temp = flag % 5;
            if (temp == 0) {
                flag = 0;
                res.add(true);
            } else {
                flag = temp;
                res.add(false);
            }
        }
        return res;
    }
}
