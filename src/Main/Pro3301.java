package Main;

public class Pro3301 {
    public static void main(String args[]){
        Pro3301 p =new Pro3301();
        int [] a={2};
        int b=16;
        System.out.println( p.minPatches(a, b));
    }
    public int minPatches(int[] nums, int n) {
        //累加的总和
        long total = 0;
        //需要补充的数字个数
        int count = 0;
        //访问的数组下标索引
        int index = 0;
        while (total < n) {
            if (index < nums.length && nums[index] <= total + 1) {
                //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
                //就变成了[1,total]U[nums[index],total+nums[index]]
                //结果就是[1,total+nums[index]]
                total += nums[index++];
            } else {
                //添加一个新数字，并且count加1
                total = total + (total + 1);
                count++;
            }
        }
        return count;
    }
}
