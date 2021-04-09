package Main;

import java.util.Arrays;
import java.util.Comparator;

public class Pro1128 {
    public static void main(String args[]) {
        Pro1128 p = new Pro1128();
        int a[][] = {{2, 2}, {1, 2}, {1, 2}, {1, 1}, {1, 2}, {1, 1}, {2, 2}};
        p.numEquivDominoPairs(a);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes.length <= 1) return 0;
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
        }
        Arrays.sort(dominoes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int flag = 1;
        for (int i = 1; i < dominoes.length; i++) {
            if (dominoes[i][0] == dominoes[i - 1][0] && dominoes[i][1] == dominoes[i - 1][1]) {
                res += flag;
                flag++;
            } else {
                flag = 1;
            }
        }
        return res;
    }

}
