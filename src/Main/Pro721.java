package Main;

import java.util.*;

public class Pro721 {
    public static void main(String args[]) {
        Pro721 p = new Pro721();
        //[["David","David0@m.co","David4@m.co","David3@m.co"],
        // ["David","David5@m.co","David5@m.co","David0@m.co"],
        // ["David","David1@m.co","David4@m.co","David0@m.co"],
        // ["David","David0@m.co","David1@m.co","David3@m.co"],
        // ["David","David4@m.co","David1@m.co","David3@m.co"]]
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("David");
        account1.add("David0@m.co");
        account1.add("David1@m.co");
        List<String> account2 = new ArrayList<>();
        account2.add("David");
        account2.add("David3@m.co");
        account2.add("David4@m.co");
        List<String> account3 = new ArrayList<>();
        account3.add("David");
        account3.add("David4@m.co");
        account3.add("David5@m.co");
        List<String> account4 = new ArrayList<>();
        account4.add("David");
        account4.add("David2@m.co");
        account4.add("David3@m.co");
        List<String> account5 = new ArrayList<>();
        account5.add("David");
        account5.add("David1@m.co");
        account5.add("David2@m.co");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        p.accountsMerge(accounts);
    }

    //建立hash表，地址到账户下标的映射
    //并查集
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hm = new HashMap<>();
        int N = accounts.size();
        int parent[] = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String address = accounts.get(i).get(j);
                if (!hm.containsKey(address)) {
                    hm.put(address, i);
                } else {
                    int index2=hm.get(address);
                    int f1=find(i,parent);
                    int f2=find(index2,parent);
                    int account = hm.get(address);
                    parent[f1] = f2;

                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < accounts.size(); i++) {
            int father =find(i,parent);
            if(HM.containsKey(father)){
                int index=HM.get(father);
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String value = accounts.get(i).get(j);
                    if (!res.get(index).contains(value)) {
                        res.get(index).add(value);
                    }
                }
            }
            else{
                List<String> l = new ArrayList<>();
                for (int j = 0; j < accounts.get(i).size(); j++) {
                    if (!l.contains(accounts.get(i).get(j))) {
                        l.add(accounts.get(i).get(j));
                    }
                }
                res.add(l);
                HM.put(father, flag);
                flag++;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            Collections.sort(res.get(i));
        }
        return res;
    }
    private int find(int x,int parent[]){
        if(parent[x]!=x){
            int father=find(parent[x],parent);
            parent[x]=father;
        }
        return parent[x];
    }
}
