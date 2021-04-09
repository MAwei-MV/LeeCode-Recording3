package Main;

import java.util.*;

public class Pro1489 {
    public static void main(String args[]) {
        Pro1489 p = new Pro1489();
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {2, 3, 4}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}};
        List<List<Integer>> lll = p.findCriticalAndPseudoCriticalEdges(6, edges);
        for (List<Integer> list : lll) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //1.先利用Kruskal求得最小生成树得权值,edges[i] = [fromi, toi, weighti]
        //根据权值进行排序
        int MinValue = 0;
        List<List<Integer>> ll = new ArrayList<>();
        if (edges.length == 0 || n == 0) {
            ll.add(new ArrayList<>());
            ll.add(new ArrayList<>());
            return ll;
        }

        int parent[] = new int[n];
        int size[] = new int[n];
        //关键边
        List<Integer> list1 = new ArrayList<>();
        //伪关键边
        List<Integer> list2 = new ArrayList<>();

        Init(parent, size);
        MinValue = getMinValue(edges, -1, -1, parent, size);

        for (int i = 0; i < edges.length; i++) {
            Init(parent, size);
            int MinValue1 = getMinValue(edges, -1, i, parent, size);
            //关键边
            if (MinValue != MinValue1) {
                list1.add(i);
            } else {
                Init(parent, size);
                int MinValue2 = getMinValue(edges, i, -1, parent, size);
                if (MinValue2 == MinValue) list2.add(i);
            }
        }
        ll.add(list1);
        ll.add(list2);
        return ll;
    }

    //求对于边集，必须包含下标flagEdge所对应的边，必须不包括NflagEdge所对应的边的情况下，所对应的最小生成树的权值
    private int getMinValue(int[][] edges, int flagEdge, int NflagEdge, int parent[], int size[]) {
        int MinValue = 0;
        if (flagEdge >= 0) {
            parent[edges[flagEdge][0]] = edges[flagEdge][1];
            size[edges[flagEdge][1]]++;
            MinValue += edges[flagEdge][2];
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (i != NflagEdge) list.add(edges[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < list.size(); i++) {
            MinValue += union(i, parent, size, list);
        }
        return MinValue;
    }

    private int find(int x, int parent[]) {
        if (parent[x] != x) {
            int father = find(parent[x], parent);
            parent[x] = father;
        }
        return parent[x];
    }

    private int union(int index, int parent[], int size[], List<int[]> list) {
        int fx = find(list.get(index)[0], parent);
        int fy = find(list.get(index)[1], parent);
        if (fx == fy) {
            return 0;
        } else {
            if (size[fx] >= size[fy]) {
                parent[fy] = fx;
                size[fx] += size[fy];
            } else {
                parent[fx] = fy;
                size[fy] += size[fx];
            }
            return list.get(index)[2];
        }
    }

    private void Init(int parent[], int size[]) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
}
