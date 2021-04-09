package Main;

public class Pro547 {
    public static void main(String args[]){
        Pro547 p =new Pro547();
        int a[][]={{1,1,0},{1,1,0},{0,0,1}};
        p.findCircleNum(a);
    }
    public int findCircleNum(int[][] isConnected){
        int count=isConnected.length;
        int size[]=new int [isConnected.length];
        int parent[]=new int[isConnected.length];

        //初始化
        for(int i=0;i<isConnected.length;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    count=union(count,i,j,parent,size);
                }
            }
        }
        return count;
    }

    private int find(int parent[],int size[],int x){
        if(parent[x]!=x){
            int father=find(parent,size,parent[x]);
            parent[x]=father;
        }
        return parent[x];
    }
    private int union(int count,int x,int y,int parent[],int size[]){
        int fx=find(parent,size,x);
        int fy=find(parent,size,y);
        if(fx!=fy && size[fx]>=size[fy]){
            parent[fy]=fx;
            size[fx]+=size[fy];
            count --;
        }
        else if(fx!=fy && size[fx]<size[fy]){
            parent[fx]=fy;
            size[fy]+=size[fx];
            count --;
        }
        return count;
    }
}
