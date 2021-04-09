package Main;

import java.util.Arrays;
import java.util.Comparator;

public class Pro435 {
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length<=1) return 0;
        Arrays.sort(intervals,new Comparator<int []>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int start=intervals[0][0];
        int end=intervals[0][1];
        int res=0;
        for(int i=1;i<intervals.length;i++){
            if(start==intervals[i][0]) res++;
            else {
                if(intervals[i][0]<end){
                    if(end>intervals[i][1]){
                        start=intervals[i][0];
                        end=intervals[i][1];
                    }
                    res++;
                }
                else if(intervals[i][0]>=end){
                    start=intervals[i][0];
                    end=intervals[i][1];
                }
            }
        }
        return res;
    }
}
