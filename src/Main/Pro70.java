package Main;

public class Pro70 {
    public int climbStairs(int n){
        if(n<=3) return n;
        int res[]=new int [n+1];
        res[1]=1;
        res[2]=2;
        res[3]=3;
        for(int i=4;i<n+1;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }

}
