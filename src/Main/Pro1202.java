package Main;

import java.lang.reflect.Array;
import java.util.*;

public class Pro1202 {
    public static void main(String args[]){
        Pro1202 p =new Pro1202();
        String s="otilzqqoj";
        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        list1.add(3);
        List<Integer> list2=new ArrayList<>();
        list2.add(7);
        list2.add(3);
        List<Integer> list3=new ArrayList<>();
        list3.add(3);
        list3.add(8);
        List<Integer> list4=new ArrayList<>();
        list4.add(1);
        list4.add(7);
        List<Integer> list5=new ArrayList<>();
        list5.add(1);
        list5.add(0);
        List<Integer> list6=new ArrayList<>();
        list6.add(0);
        list6.add(4);
        List<Integer> list7=new ArrayList<>();
        list7.add(0);
        list7.add(6);
        List<Integer> list8=new ArrayList<>();
        list8.add(3);
        list8.add(4);
        List<Integer> list9=new ArrayList<>();
        list9.add(2);
        list9.add(5);
        List<List<Integer>> ll=new ArrayList<>();
        ll.add(list1);
        ll.add(list2);
        ll.add(list3);
        ll.add(list4);
        ll.add(list5);
        ll.add(list6);
        ll.add(list7);
        ll.add(list8);
        ll.add(list9);
        System.out.println(p.smallestStringWithSwaps(s,ll));
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s.length()==0|| pairs.size()==0) return s;
    char c[]=s.toCharArray();
    int N=c.length;
    int parent[]=new int[N];
    int size[]=new int[N];
        Arrays.fill(size,1);
        for(int i=0;i<N;i++){
            parent[i]=i;
        }
        HashMap<Integer, ArrayList<Character>> hm =new HashMap<>();
    for(List<Integer> list:pairs){
        int fx=find(list.get(0),parent);
        int fy=find(list.get(1),parent);
        if(fx==fy){
            continue;
        }
        else{
        if(size[fx]>=size[fy]){
            parent[fy]=fx;
            size[fx]+=size[fy];
        }
        else{
            parent[fx]=fy;
            size[fy]+=size[fx];
        }
        }
    }
    for(int i=0;i<N;i++){
        int fi=find(i,parent);
        hm.putIfAbsent(fi,new ArrayList<Character>());
        hm.get(fi).add(c[i]);
    }
    for(ArrayList<Character> l:hm.values()){
        Collections.sort(l);
        }
    for(int i=0;i<N;i++){
        int fi=find(i,parent);
        char c1=hm.get(fi).get(0);
        hm.get(fi).remove(0);
        c[i]=c1;
    }
    return String.valueOf(c);
    }
    private int find(int x, int parent[]){
        if(parent[x]!=x){
            int father=find(parent[x],parent);
            parent[x]=father;
        }
        return parent[x];
    }
}
