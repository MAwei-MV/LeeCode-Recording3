package Main;

import java.util.ArrayList;
import java.util.List;

public class Pro330 {
    public static void main(String args[]){
        Pro330 p =new Pro330();
        int a[]={1,3};
        System.out.println(p.minPatches(a,6));
    }
    public int minPatches(int[] nums, int n) {
        int count =0;
        long flag=1;
        long sum=0;
        int index=0;//数组下标
        while(flag<=n){
            if((index<nums.length&&nums[index]>flag)||index>= nums.length){
                count++;
                sum+=flag;
                flag=sum+1;
            }
            else if(index<nums.length&&nums[index]<=flag){
                sum+=nums[index];
                flag=sum+1;
                index++;
            }
        }
        return count;
    }
}
