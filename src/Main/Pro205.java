package Main;

import java.util.HashMap;

public class Pro205 {
    public boolean isIsomorphic(String s,String t){
        HashMap<Character,Character> hm= new HashMap<>();
        char []c1=s.toCharArray();
        char []c2=t.toCharArray();
        if(c1.length!=c2.length) return false;
        for(int i=0;i<c1.length;i++){
            if(hm.containsKey(c1[i])){
                if(hm.get(c1[i])!=c2[i]) return false;
            }
            else{
                if(hm.containsValue(c2[i])) return false;
                hm.put(c1[i],c2[i]);
            }
        }
        return true;

    }
}
