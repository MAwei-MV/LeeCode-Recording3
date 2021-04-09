package Main;

import java.util.Arrays;

public class Pro803 {
    public static void main(String args[]) {
        Pro803 p = new Pro803();
        int[][] g = {{0, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] hits = {{6, 0}, {1, 0}, {4, 3}, {1, 2}, {7, 1}, {6, 3}, {5, 2}, {5, 1}, {2, 4}, {4, 4}, {7, 3}};
        System.out.println(p.hitBricks(g, hits)[0]);
    }

    //逆向思维+并查集
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int M1 = grid.length;
        int M2 = grid[0].length;
        int N = hits.length;
        int res[] = new int[N];
        Arrays.fill(res, -1);
        for (int i = 0; i < N; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 0) {
                res[i] = 0;
            } else {
                grid[hits[i][0]][hits[i][1]] = 0;
            }
        }
        int parent[] = new int[M1 * M2 + 1];
        int size[] = new int[M1 * M2 + 1];
        //假想点特殊处理
        parent[M1 * M2] = M1 * M2;
        size[M1 * M2]++;
        for (int i = 0; i < M1; i++) {
            for (int j = 0; j < M2; j++) {
                if (grid[i][j] == 1 && i == 0) {
                    parent[i * M2 + j] = M1 * M2;
                    size[M1 * M2]++;
                    size[j] = 1;
                } else if (grid[i][j] == 1) {
                    parent[i * M2 + j] = i * M2 + j;
                    size[i * M2 + j] = 1;
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(i * M2 + j, i * M2 + j - 1, parent, size);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(i * M2 + j, (i - 1) * M2 + j, parent, size);
                    }
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (res[i] == 0)
                continue;
            int x = hits[i][0];
            int y = hits[i][1];
            parent[x * M2 + y] = (x == 0 ? parent.length - 1 : x * M2 + y);
            size[x * M2 + y] = 1;
            grid[x][y] = 1;
            int account0 = size[M1 * M2];
            if (x == 0)
                size[M1 * M2]++;
            if (x > 0 && grid[x - 1][y] == 1) {
                union((x - 1) * M2 + y, x * M2 + y, parent, size);
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                union(x * M2 + y, x * M2 + y - 1, parent, size);
            }
            if (x < M1 - 1 && grid[x + 1][y] == 1) {
                union(x * M2 + y, (x + 1) * M2 + y, parent, size);
            }
            if (y < M2 - 1 && grid[x][y + 1] == 1) {
                union(x * M2 + y, x * M2 + y + 1, parent, size);
            }
            res[i] = size[M1 * M2] - account0 - 1 >= 0 ? size[M1 * M2] - account0 - 1 : 0;
        }
        return res;
    }

    private void union(int x, int y, int parent[], int size[]) {
        int fx = find(x, parent);
        int fy = find(y, parent);
        if (fx == fy) return;
        if (parent[fy] == parent.length - 1) {
            parent[fx] = fy;
            size[fy] += size[fx];
            return;
        } else if (parent[fx] == parent.length - 1) {
            parent[fy] = fx;
            size[fx] += size[fy];
            return;
        }
        if (size[fy] >= size[fx]) {
            parent[fx] = fy;
            size[fy] += size[fx];
        } else {
            parent[fy] = fx;
            size[fx] += size[fy];
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
