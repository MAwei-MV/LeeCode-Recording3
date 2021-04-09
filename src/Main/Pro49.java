package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pro49 {
    public static void main(String args[]){
        Pro49 p =new Pro49();
        String s[]= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(p.groupAnagrams(s));
    }

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ll =new ArrayList<>();
        HashMap<String ,List<String>> hm =new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] c= strs[i].toCharArray();
            Arrays.sort(c);
            String newS=new String(c);
            if(hm.containsKey(newS)){
                hm.get(newS).add(strs[i]);
            }else{
                List<String> list =new ArrayList<>();
                list.add(strs[i]);
                hm.put(newS,list);
            }
        }
        for(List<String> list: hm.values()){
            ll.add(list);
        }
        return ll;
    }
}
