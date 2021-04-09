package Main;

import java.util.HashMap;
import java.util.Map;

public class Pro509 {
    /*public int fib(int n){
        int res[] =new int [n+1];
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }*/
    public int fib(int n) {
        return fib(n, new HashMap());
    }

    public int fib(int n, Map<Integer, Integer> map) {
        if (n < 2)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int first = fib(n - 1, map);
        int second = fib(n - 2, map);
        int res = (first + second);
        map.put(n, res);
        return res;
    }
}
