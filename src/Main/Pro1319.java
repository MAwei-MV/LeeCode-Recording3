package Main;

public class Pro1319 {
    public static void main(String args[]) {
        Pro1319 p = new Pro1319();
        int n = 4;
        int a[][] = {{0, 1}, {0, 2}, {1, 2}};
        p.makeConnected(n, a);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int size[] = new int[n];
        int parent[] = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            union(x, y, parent, size);
        }
        return --count;
    }

    int count;

    private void union(int x, int y, int parent[], int size[]) {
        int fx = find(x, parent);
        int fy = find(y, parent);
        if (fx == fy) {
            return;
        } else {
            if (size[fx] >= size[fy]) {
                parent[fy] = fx;
                size[fx] += size[fy];
            } else {
                parent[fx] = fy;
                size[fy] += size[fx];
            }
            count--;
        }
    }

    private int find(int x, int parent[]) {
        if (parent[x] != x) {
            int father = find(parent[x], parent);
            parent[x] = father;
        }
        return parent[x];
    }

}
