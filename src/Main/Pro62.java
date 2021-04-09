package Main;

public class Pro62 {
    public static void main(String args[]){
Pro62 p =new Pro62();
System.out.println(p.uniquePaths(7,3));
    }
    int res = 0;
    public int uniquePaths(int m, int n) {
     if(m==1||n==1)return 1;
     if(m==2||n==2) return (m==2?n:m);
     if(m==3||n==3) return (m==3?helper(n):helper(m));
     else return (uniquePaths(m,n-1)+uniquePaths(m-1,n));
    }
    private int helper(int index){
        if(index%2==0) return (1+index)*index/2;
        else return (1+index)*(index/2)+index/2+1;
    }
//蠻力，動態規劃都超時
    /*private void helper(int i, int j, int m, int n) {
        if(i==m-1&&j==n-1) res++;
        if (i < m - 1&&j<=n-1) {

            helper(i + 1, j, m, n);
        }
        if (j < n - 1&&i<=m) {

            helper(i, j + 1, m, n);
        }
    }*/
    //動態規劃

}
