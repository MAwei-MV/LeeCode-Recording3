package Main;

import java.util.Arrays;

public class Pro1105 {
    public static void main(String args[]){
        int a[][]=
                {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int i=4;
        Pro1105 p =new Pro1105();
        System.out.println(p.minHeightShelves(a,i));
    }
    public int minHeightShelves(int[][] books, int shelf_width) {
        if(books.length==0) return 0;
        int high=0;
        int N=books.length;
        int dp[]=new int [N+1];
        Arrays.fill(dp,1000);
        dp[0]=0;
        for(int i=0;i<books.length;i++){
        int j=i-1;
        int w=books[i][0];
        int maxHigh=books[i][1];
        while(j>=0&&w+books[j][0]<=shelf_width){
            if(maxHigh<books[j][1]) maxHigh=books[j][1];
            dp[i+1]=Math.min(dp[i+1],dp[j]+maxHigh);
            w+=books[j][0];
            j--;
        }
        dp[i+1]=Math.min(dp[i]+books[i][1],dp[i+1]);
        }
        return dp[dp.length-1];
    }
}