package Main;

import java.util.Arrays;

public class Pro628 {
    public static void main(String args[]) {
        Pro628 p = new Pro628();
        int[] a = {-100, -2, -3, 1};
        System.out.println(p.maximumProduct(a));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        if (nums[0] >= 0 || nums[N - 1] < 0)
            return nums[N - 1] * nums[N - 2] * nums[N - 3];
        else {
            int Max = Math.max(nums[0] * nums[1], nums[N - 2] * nums[N - 3]);
            return Max * nums[N - 1];
        }
    }
}
