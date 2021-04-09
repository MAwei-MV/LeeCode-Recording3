package Main;

import java.util.*;

public class Pro399 {
    public static void main(String args[]){
        Pro399 p =new Pro399();
        List<List<String>> ll=new ArrayList<>();
        List<String> l1=new ArrayList<>();
        l1.add("a");
        l1.add("b");
        List<String> l2=new ArrayList<>();
        l2.add("b");
        l2.add("c");
        List<String> l8=new ArrayList<>();
        l8.add("c");
        l8.add("d");
        ll.add(l1);
        ll.add(l2);
        ll.add(l8);

        List<String> l3=new ArrayList<>();
        l3.add("a");
        l3.add("c");
        List<String> l4=new ArrayList<>();
        l4.add("b");
        l4.add("a");
        List<String> l5=new ArrayList<>();
        l5.add("a");
        l5.add("e");
        List<String> l6=new ArrayList<>();
        l6.add("a");
        l6.add("a");
        double[]values={2.0,3.0,4.0};
        List<List<String>> lll=new ArrayList<>();
        lll.add(l3);
        lll.add(l4);
        lll.add(l5);
        lll.add(l6);
        p.calcEquation(ll,values,lll);
    }
    //①带权并查集
    public double[] calcEquation(List<List<String>> equations,double[] values, List<List<String>> queries) {
        Set<String> set=new HashSet<>();
        for(List<String> l:equations){
            set.add(l.get(0));
            set.add(l.get(1));
        }
        HashMap<String, Integer> hm=new HashMap<>();
        int x=0;
        for(String s:set){
            hm.put(s,x);
            x++;
        }
        int num=set.size();
        double w[]=new double [num];
        int parent[]=new int [num];
        //初始化
        for(int i=0;i<num;i++){
            w[i]=1;
            parent[i]=i;
        }
        //union
        int t=0;
        for(List<String> list: equations){
            int i=hm.get(list.get(0));
            int j=hm.get(list.get(1));
            merge(parent,w,i,j,values[t]);
            t++;
        }
        //find
        int flag=0;
        double res[]=new double[queries.size()];
        for(List<String> list:queries){
            if(!hm.containsKey(list.get(0))||!hm.containsKey(list.get(1))){
                res[flag]=-1;
                flag++;
                continue;
            }
            int i=hm.get(list.get(0));
            int j=hm.get(list.get(1));
            int fi=find(parent,w,i);
            int fj=find(parent,w,j);
            if(fi==fj){
                res[flag]=w[i]/w[j];
            }
            else{
                res[flag]=-1;
            }
            flag++;
        }
        for(int i=0;i<res.length;i++){
            System.out.println(res[0]);
        }
        return res;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = find(f, w, x);
        int fy = find(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }
    public int find(int parent[],double w[],int x){
        if(parent[x]!=x){
            int father = find(parent, w, parent[x]);
            w[x] = w[x] * w[parent[x]];
            parent[x] = father;
        }
        return parent[x];
    }
}
