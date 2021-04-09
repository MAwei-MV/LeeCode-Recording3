package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees=new int [numCourses];
        List<List<Integer>> adjacency =new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adjacency.add(new ArrayList<>());
        for(int res[]:prerequisites){
            indegrees[res[0]]++;
           adjacency.get(res[1]).add(res[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();
            numCourses--;
            for(int l:adjacency.get(pre)){
                if(--indegrees[l]==0) queue.add(l);
            }
        }
        return numCourses==0;
    }
}
