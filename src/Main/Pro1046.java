package Main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Pro1046 {
    /*public int lastStoneWeight(int [] stones){
        if(stones.length==1)return stones[0];
        Arrays.sort(stones);
        int i=stones.length-1;
        while(i>=1){
            int temp=stones[i]-stones[i-1];
            if(temp==0) {
                if(i==1) stones[0]=0;
                i-=2;
            }
            else{
                int j=0;
                for(;j<i-1;j++){
                    if(stones[j]>temp) break;
                }

                for(int k=i-1;k>j;k--){
                    stones[k]=stones[k-1];
                }
                stones[j]=temp;
                i--;
            }
        }
        return stones[0];
    }*/
    public static void main(String args[]){
        int a[]={12,21,11,6,43,12,9,5};
        Pro1046 p =new Pro1046();
        System.out.println(p.lastStoneWeight(a));
    }
    public int lastStoneWeight(int[] stones) {
        //优先级队列
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
