package Main;

public class Pro779 {
    public static void main(String args[]) {
        Pro779 p = new Pro779();
        int N = 4;
        int K = 4;
        System.out.println(p.kthGrammar(N, K));
    }

    //蛮力，超出内存限制
  /*  public int kthGrammar(int N, int K) {

        return helper(N)[K-1];
    }

    private int[] helper(int K) {
        if (K == 1) {
            return new int[]{0};
        }
            int[] Pre = helper(K - 1);
            int[] newInt = new int[Pre.length*2];
            for (int i = 0; i < Pre.length; i++) {
                if (Pre[i] == 0) {
                    newInt[2 * i] = 0;
                    newInt[2 * i + 1] = 1;
                } else {
                    newInt[2 * i] = 1;
                    newInt[2 * i + 1] = 0;
                }
        }
        return newInt;
    }*/
    //不断折半
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (N == 2) return K == 1 ? 0 : 1;
        int i = N;
        int sign = 1;
        int flag = (int) Math.pow(2, N - 1);
        while (i > 2) {
            if (K > flag / 2) {
                K = K - flag / 2;
                sign = -sign;
            }
            flag /= 2;
            i--;
        }
        if (K == 1 && sign == 1 || K == 2 && sign == -1) {
            return 0;
        }
        return 1;

    }
}
