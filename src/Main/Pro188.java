package Main;

import java.util.Arrays;

public class Pro188 {
    public static void main(String args[]){
        Pro188 p =new Pro188();
        int a[]={2,4,1};
        System.out.println(p.maxProfit(2,a));
    }
    public int maxProfit(int k,int[] prices){
        if(prices.length<=1||k<1) return 0;
        int res[][]=new int [prices.length][2*k+1];
        for(int i=0;i<res.length;i++)
        Arrays.fill(res[i],-100000);
        for(int i=0;i<res.length;i++)
            res[i][0]=0;
        res[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            int f=Math.min(2*k+1,i+2);
            for(int j=1;j<f;j++){
                //奇买偶卖
                if(j%2==0)
               res[i][j]=Math.max(res[i-1][j],res[i-1][j-1]+prices[i]);
                else
                res[i][j]=Math.max(res[i-1][j],res[i-1][j-1]-prices[i]);
            }
        }
        Arrays.sort(res[res.length-1]);
        return res[res.length-1][2*k];
    }
}
