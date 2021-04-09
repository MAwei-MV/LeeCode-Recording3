package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pro1262 {
    public static void main(String arg[]) {
        Pro1262 p = new Pro1262();
        int[] s = {2, 6, 2, 2, 7};
        p.maxSumDivThree(s);
    }

    public int maxSumDivThree(int[] nums) {
        int res = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0) {
                res += nums[i];
            } else if (nums[i] % 3 == 1) {
                list1.add(nums[i]);
                flag += nums[i];
            } else {
                flag += nums[i];
                list2.add(nums[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (flag % 3 == 0) return res + flag;
        if (flag % 3 == 1) {
            if (list2.size() >= 2 && list1.size() >= 1) {
                int temp = Math.min(list2.get(0) + list2.get(1), list1.get(0));
                return res + flag - temp;
            } else if (list2.size() >= 2) {
                return res + flag - list2.get(0) - list2.get(1);
            } else if (list1.size() >= 1) {
                return res + flag - list1.get(0);
            }
        }
        if (flag % 3 == 2) {
            if (list1.size() >= 2 && list2.size() >= 1) {
                int temp = Math.min(list1.get(0) + list1.get(1), list2.get(0));
                return res + flag - temp;
            } else if (list1.size() >= 2) {
                return res + flag - list1.get(0) - list1.get(1);
            } else if (list2.size() >= 1) {
                return res + flag - list2.get(0);
            }
        }
        return res;
    }
}