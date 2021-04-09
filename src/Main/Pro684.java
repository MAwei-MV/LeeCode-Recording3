package Main;

public class Pro684 {
    public int[] findRedundantConnection(int[][] edges) {
        int res[]=new int [2];
        if(edges.length==0) return res;
        int N = edges.length;
        int parent[] = new int[N + 1];
        int size[] = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            int x=edges[i][0];
            int y=edges[i][1];
            int fx=find(parent,x);
            int fy=find(parent,y);
            if(fx==fy){
                res[0]=x;
                res[1]=y;
                break;
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
        return res;
    }
    private int find (int parent[],int x){
        if(parent[x]!=x){
            int father=find(parent,parent[x]);
            parent[x]=father;
        }
        return parent[x];
    }

}
