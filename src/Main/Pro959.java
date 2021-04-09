package Main;

public class Pro959 {
    //妙啊
    int count = 1;

    public static void main(String args[]) {
        String[] s = {"/\\", "\\/"};
        Pro959 p = new Pro959();
        System.out.println(p.regionsBySlashes(s));
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        if (N == 0) return 0;
        //N+1个顶点
        int parent[] = new int[(N + 1) * (N + 1) + 1];
        int size[] = new int[(N + 1) * (N + 1) + 1];
        //初始化
        for (int i = 0; i <= (N + 1) * (N + 1); i++) {
            if (i <= N || (i - N) % (N + 1) == 0 || i % (N + 1) == 0 || i >= N * (N + 1)) {
                parent[i] = (N + 1) * (N + 1);
            } else {
                parent[i] = i;
            }
            size[i]++;
        }
        for (int i = 0; i < N; i++) {
            char c[] = grid[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == ' ') continue;
                if (c[j] == '/') {
                    union(i * (N + 1) + j + 1, (i + 1) * (N + 1) + j, parent, size);
                }
                if (c[j] == '\\') {
                    union(i * (N + 1) + j, (i + 1)*(N+1) + j+1, parent, size);
                }
            }
        }
        return count;
    }

    private int find(int x, int parent[]) {
        if (parent[x] != x) {
            int father = find(parent[x], parent);
            parent[x] = father;
        }
        return parent[x];
    }

    private void union(int x, int y, int parent[], int size[]) {
        int fx = find(x, parent);
        int fy = find(y, parent);
        if (fx == fy) {
            count++;
        } else {
            if (fx == parent.length - 1) {
                parent[fy] = fx;
            } else if (fy == parent.length - 1) {
                parent[fx] = fy;
            } else if (size[fx] >= size[fy]) {
                parent[fy] = fx;
                size[fx] += size[fy];
            } else {
                parent[fx] = fy;
                size[fy] += size[fx];
            }
        }
    }
}