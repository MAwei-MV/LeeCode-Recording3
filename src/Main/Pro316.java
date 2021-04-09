package Main;

import java.util.HashMap;
import java.util.Map;

public class Pro316 {
    public static void main(String args[]){
        String s="davbasda";
        Pro316 p= new Pro316();
        System.out.println(p.removeDuplicateLetters(s));
    }
    public String removeDuplicateLetters(String s) {
        char [] c=s.toCharArray();
       Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<c.length;i++){
            hm.put(c[i],hm.getOrDefault(c[i],0)+1);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<c.length;i++){
            if(hm.get(c[i])==1){
                sb.append(c[i]);
            }
            else if(hm.get(c[i])!=0){
                if(c[i+1]>c[i]){
                    sb.append(c[i]);
                    hm.replace(c[i],0);
                }else{
                    hm.replace(c[i],hm.get(c[i])-1);
                }
            }
        }
        return sb.toString();
    }
}
