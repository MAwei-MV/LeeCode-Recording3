package Main;

import java.util.*;

public class Pro3991 {
    public static void main(String args[]){
        Pro3991 p =new Pro3991();
        List<List<String>> ll=new ArrayList<>();
        List<String> l1=new ArrayList<>();
        l1.add("a");
        l1.add("b");
        List<String> l2=new ArrayList<>();
        l2.add("a");
        l2.add("c");
        ll.add(l1);
        ll.add(l2);

        List<String> l3=new ArrayList<>();
        l3.add("b");
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
        double[]values={2.0,3.0};
        List<List<String>> lll=new ArrayList<>();
        lll.add(l3);
        lll.add(l4);
        lll.add(l5);
        lll.add(l6);
        p.calcEquation(ll,values,lll);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        int[] f = new int[nvars];
        double[] w = new double[nvars];
        Arrays.fill(w, 1.0);
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                int fa = findf(f, w, ia), fb = findf(f, w, ib);
                if (fa == fb) {
                    result = w[ia] / w[ib];
                }
            }
            ret[i] = result;
        }
        for(int i=0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
        return ret;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findf(f, w, x);
        int fy = findf(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public int findf(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findf(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }
}

