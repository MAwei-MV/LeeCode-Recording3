package Main;

import java.util.LinkedList;
import java.util.Queue;

public class Pro189 {
    public static void main(String args[]){
        Pro189 p =new Pro189();
        int a[]={1,2,3,4,5,6,7};
        int k=3;
        p.ratate(a,k);
    }

    //O(1)的空间复杂度下，翻转两次
    public void ratate(int[] nums,int k){
        int len=nums.length;
        int f=k%len;
    for(int i=0;i<len/2;i++){
        int temp=nums[i];
        nums[i]=nums[len-i-1];
        nums[len-i-1]=temp;
    }
    for(int i=0;i<f/2;i++){
        int temp=nums[i];
        nums[i]=nums[f-i-1];
        nums[f-i-1]=temp;
    }
        for(int i=f;i<f+(len-f)/2;i++){
            int temp=nums[i];
            nums[i]=nums[len-i+f-1];
            nums[len-i-f-1]=temp;
        }
    }
}
