package Main;

import java.util.Arrays;

public class Pro53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        //res[i]表示以nums[i]结束的最大子数组
        int res[] = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1] + nums[i], nums[i]);
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }
}
