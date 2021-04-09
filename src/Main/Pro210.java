package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro210 {
    public int[] findOrder(int numCourses,int[][] prerequisites){
        int res[]=new int [numCourses];
        if(numCourses==0) return res;
        //表示入度
        int degree[] =new int [numCourses];
        //邻接表
        List<List<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int [] course:prerequisites){
            degree[course[0]]++;
            adjacency.get(course[1]).add(course[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        int flag=0;
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();
            res[flag]=pre;
            flag++;
            for(int l:adjacency.get(pre)){
                if(--degree[l]==0) queue.add(l);
            }
        }
        if(flag!=numCourses){
            int empty[]=new int [0];
            return empty;
        }
        else {
            return res;
        }
    }
}
