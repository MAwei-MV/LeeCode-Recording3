package Main;

import java.util.Arrays;

public class Pro1049 {
    public static void main(String args[]){
        Pro1049 p =new Pro1049();
        int []a ={31,26,33,21,40};
        System.out.println(p.lastStoneWeightII(a));
    }
    //01背包问题不熟悉
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones) sum+=stone;
        int []dp=new int [sum/2+1];
        for(int i=0;i<stones.length;i++){
            for(int j=sum/2;j>=stones[i];j--){
                dp[j]=Math.max(dp[j-stones[i]]+stones[i],dp[j]);
            }
        }
        return sum-2*dp[sum/2];
    }

    /*public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) sum += stone;
        int m = sum / 2;
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; ++i) {
            int currStone = stones[i];
            for (int j = m; j >= currStone; j--) {
                dp[j] = Math.max(dp[j], dp[j - currStone] + currStone);
            }
        }
        int res = sum - 2 * dp[m];
        return res;
    }*/
    //算法错误
   /* public int lastStoneWeightII(int [] stones){
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

}
