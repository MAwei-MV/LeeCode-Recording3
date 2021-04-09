package Main;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Pro239 {
    public static void main(String args[]){
        int a[]= {1,-1};
        Pro239 p =new Pro239();
        System.out.println(p.maxSlidingWindow(a,1));
    }
    public int[] maxSlidingWindow(int[] nums,int k){
        LinkedList<Integer> ll = new LinkedList<>();
        if(nums.length<=k){
            Arrays.sort(nums);
            return new int[]{nums[nums.length-1]};
        }
        int res[]=new int [nums.length-k+1];
        int flag=0;
        int i=0;
        while(i<nums.length){
                while(!ll.isEmpty()&&nums[ll.peekFirst()]<nums[i]){
                    ll.pollFirst();
                }
              ll.addFirst(i);
            flag++;
            if(flag>=k){
                    while(i-k+1>ll.peekLast()){
                        ll.pollLast();
                    }
                res[flag-k]=nums[ll.peekLast()];
            }
            i++;
        }
        return res;
    }

}
