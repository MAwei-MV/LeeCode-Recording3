package Main;

import java.util.ArrayList;
import java.util.List;

public class Pro830 {
    public List<List<Integer>> largeGroupPositions(String s){
        char c[] =s.toCharArray();
        if(c.length==0) return null;
        List<List<Integer>> ll=new ArrayList<>();
        int i=0;
        int start=0;
        int count=0;
        char flag=0;
        while(i<c.length){
            if(flag==c[i]){
                i++;
                count++;
            }
            else{
                if(count>=3){
                   List<Integer> list=new ArrayList<>();
                   list.add(start);
                   list.add(i-1);
                   ll.add(list);
                }
                count=1;
                start=i;
                flag=c[i];
                i++;
            }
        }
        if(count>=3){
            List<Integer> list=new ArrayList<>();
            list.add(start);
            list.add(i-1);
            ll.add(list);
        }
        return ll;
    }
}
