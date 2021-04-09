package Main;

public class Pro714 {
    public static void main(String args[]){
        Pro714 p= new Pro714();
        int a[]={1,3,2,8,4,9};
        System.out.println(p.maxProfit(a,2));
    }
    //超时
    /*public int maxProfit(int[] prices,int fee){
        if(prices.length<=1) return 0;
        int dp[]=new int [prices.length+1];//第prices.length天能获得的最大收益
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=i;j++){
                int temp=dp[j-1]+Math.max(0,prices[i-1]-prices[j-1]-fee);
                if(temp>dp[i])
                dp[i]=temp;
            }
        }
        return dp[dp.length-1];
    }*/
    //dp[i][0]表示第i天不持有；
    /*public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //dp[i][0]表示第i天不持有股票；
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            //dp[i][1]表示第i天持有股票；
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }*/
    //优化后：二维变一维
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[]dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //dp[i][0]表示第i天不持有股票；
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            //dp[i][1]表示第i天持有股票；
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
