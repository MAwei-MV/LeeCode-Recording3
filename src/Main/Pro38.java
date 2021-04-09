package Main;

public class Pro38 {
    public static void  main(String args[]){
        Pro38 p =new Pro38();
        System.out.println(p.countAndSay(5));
    }
    public String countAndSay(int n){
        if(n==1) return "1";
        if(n==2) return "11";
       String res[]=new String [n+1];
        res[1]="1";
        res[2]="11";
        for(int i=3;i<=n;i++){
            char c[]=res[i-1].toCharArray();
            StringBuffer sb=new StringBuffer();
            // (int)ch - (int)('0');
            int flag= c[0]-'0';
            int count=1;
            for(int j=1;j<c.length;j++){
                if(c[j]-'0'==flag){
                    count++;
                    continue;
                }
                else{
                    sb.append(count);
                    sb.append(flag);
                    flag=c[j]-'0';
                    count=1;
                }
            }
            sb.append(count);
            sb.append(flag);
            res[i]= sb.toString();;
        }
        return res[n];
    }

}
