package Main;

public class Pro123 {
    public static void main(String args[]){
        Pro123 p =new Pro123();
        int[] a= {3,3,5,0,0,3,1,4};
        System.out.println(p.maxProfit(a));
    }
    public int maxProfit(int[] prices){
        if(prices.length<=1)return 0;
        //res[i][0][1]表示针对第i次交易不持有股票，且已经交易了1次；
        int res[] [] []=new int[prices.length] [2][3];
        res[0][1][0]=-prices[0];
        res[0][0][1]=-100000;
        res[0][1][1]=-100000;  res[0][0][2]=-100000;

        for(int i=1;i<prices.length;i++){
          res[i][0][1]=Math.max(res[i-1][1][0]+prices[i],res[i-1][0][1]);
          res[i][0][2]=Math.max(res[i-1][1][1]+prices[i],res[i-1][0][2]);
          res[i][1][0]=Math.max(res[i-1][1][0],-prices[i]);
          res[i][1][1]=Math.max(res[i-1][1][1],res[i-1][0][1]-prices[i]);
        }
        int r=Math.max(res[prices.length-1][0][2],res[res.length-1][0][1]);
        return r>=0?r:0;
    }
}
