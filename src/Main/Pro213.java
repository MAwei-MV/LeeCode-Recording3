package Main;

public class Pro213 {
    public int rob(int[] nums){
        //res1[i]表示第一家不偷的情况下，能收获的最大利益
        //res2[i]表示第一家偷的情况下，能收获的最大利益
        if(nums.length<=1) return nums[0];
        int res1[]=new int[nums.length];
        res1[0]=0;
        res1[1]=nums[1];
        int res2[]=new int [nums.length];
        res2[0]=nums[0];
        res2[1]=res2[0];
        for(int i=2;i<nums.length;i++){
            res1[i]=Math.max(res1[i-1],res1[i-2]+nums[i]);
            res2[i]=Math.max(res2[i-1],res2[i-2]+nums[i]);
        }
        return Math.max(res1[res1.length-1],res2[res2.length-2]);
    }
}
