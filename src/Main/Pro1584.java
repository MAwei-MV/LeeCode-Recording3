package Main;

import java.util.*;

public class Pro1584 {
    public static void main(String args[]) {
        Pro1584 p = new Pro1584();
        int a[][] = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        p.minCostConnectPoints(a);
    }

    /*public int minCostConnectPoints(int[][] points) {
        //prim算法
        int N = points.length;
        if (N == 0) return 0;
        int res = 0;
        int newPoints[][] = new int[N][N];

        //建立邻接矩阵
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                newPoints[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                newPoints[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        //lowcast存放与连接图中顶点的最小值
        int lowcast[] = new int[N];
        List<Integer> count = new ArrayList<>();
        count.add(0);
        lowcast[0] = -1;
        for (int i = 1; i < N; i++) {
            lowcast[i] = newPoints[i][0];
        }
        while (count.size() < N) {
            //选取lowcast数组中与已在图中的顶点最小距离的点
            int minDistance = Integer.MAX_VALUE;
            int flag = 0;
            for (int i = 0; i < N; i++) {
                if (lowcast[i] > 0 && lowcast[i] < minDistance) {
                    flag = i;
                    minDistance = lowcast[i];
                }
            }
                //将选取的点加入图中
                count.add(flag);
                //计入最短距离
                res += minDistance;
                //更新lowcast
                for (int j = 0; j < N; j++) {
                    if (j == flag) {
                        lowcast[j] = -1;
                    } else {
                        if (lowcast[j] != -1)
                            lowcast[j] = Math.min(lowcast[j], newPoints[j][flag]);
                    }
                }
            }
        return res;
    }*/
    //Kruskal（并查集)
    //执行用时：前50.79%；
    //内存消耗：前54.08%
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        int parent[] = new int[N];
        int size[] = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        List<Kruskal> count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Kruskal kruskal = new Kruskal(i, j, points);
                count.add(kruskal);
            }
        }
        Collections.sort(count, new Comparator<Kruskal>() {
            @Override
            public int compare(Kruskal o1, Kruskal o2) {
                return o1.distance - o2.distance;
            }
        });
        int res = 0;
        for (int i = 0; i < count.size(); i++) {
            int x = count.get(i).start;
            int y = count.get(i).end;
            int fx = find(x, parent);
            int fy = find(y, parent);
            if (fx == fy) {
                continue;
            } else {
                if (size[fx] >= size[fy]) {
                    parent[fy] = fx;
                    size[fx] += size[fy];
                } else {
                    parent[fx] = fy;
                    size[fy] += size[fx];
                }
                res += count.get(i).distance;
            }
        }
        return res;
    }

    private int find(int x, int parent[]) {
        if (parent[x] != x) {
            int father = find(parent[x], parent);
            parent[x] = father;
        }
        return parent[x];
    }


}

class Kruskal {
    //两条边
    int start;
    int end;
    //距离（权重）
    int distance;

    public Kruskal(int start, int end, int[][] points) {
        this.start = start;
        this.end = end;
        this.distance = Math.abs(points[start][0] - points[end][0]) + Math.abs(points[start][1] - points[end][1]);
    }

}