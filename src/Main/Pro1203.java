package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro1203 {
    public static void main(String args[]) {
        Pro1203 p = new Pro1203();
        int n = 3;
        int m = 1;
        int group[] = {-1, 0, -1};
        List<List<Integer>> before = new ArrayList<>();
        // [[],[6],[5],[6],[3,6],[],[],[]]
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        p.sortItems(n, m, group, before);
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //转换思想：将group[i]=-1转换为group[i]=newM，用于确定它的执行组
        int flagM = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = flagM;
                flagM++;
            }
        }
        int newM = flagM + 1;
        int indegreeItem[] = new int[n];
        int indegreeGroup[] = new int[newM];
        //结果集
        int res[] = new int[n];
        int[] empty = new int[0];
        List<List<Integer>> adjItem = new ArrayList<>();
        List<List<Integer>> adjGroup = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjItem.add(new ArrayList<>());
        }
        for (int i = 0; i < newM; i++) {
            adjGroup.add(new ArrayList<>());
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> list = beforeItems.get(i);
            if (list.size() > 0) {
                indegreeItem[i] = list.size();
                for (int index : list) {
                    adjItem.get(index).add(i);
                    if (group[i] != group[index] && group[i] != -1 && group[index] != -1) {
                        adjGroup.get(group[index]).add(group[i]);
                        indegreeGroup[group[i]]++;
                    }
                }
            }
        }
        Queue<Integer> queueGroup = new LinkedList<>();
        Queue<Integer> queueItems = new LinkedList<>();
        for (int i = 0; i < indegreeGroup.length; i++) {
            if (indegreeGroup[i] == 0) {
                queueGroup.add(i);
            }
        }
        int flag = 0;
        while (!queueGroup.isEmpty()) {
            int tempGroup = queueGroup.poll();

            for (int i = 0; i < indegreeItem.length; i++) {
                if (indegreeItem[i] == 0 && group[i] == tempGroup) {
                    queueItems.add(i);
                }
            }
            while (!queueItems.isEmpty()) {
                int tempItem = queueItems.poll();
                res[flag] = tempItem;
                flag++;
                for (int t1 : adjItem.get(tempItem)) {
                    if (--indegreeItem[t1] == 0 && group[t1] == tempGroup) {
                        queueItems.add(t1);
                    }
                }
            }
            for (int t2 : adjGroup.get(tempGroup)) {
                if (--indegreeGroup[t2] == 0) queueGroup.add(t2);
            }
        }
        if (flag != n) {
            return empty;
        }
        return res;
    }
}
