package Main;

import java.util.Stack;

public class Pro153 {
    public int findMin(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int right=nums.length-1;
        int left=0;
        int mid=0;
        while(right>left){
            mid= left+(right-left)/2;
        if(nums[right]<nums[mid])
            left=mid+1;
        else
            right=mid;
    }
        return nums[left];
    }
}
