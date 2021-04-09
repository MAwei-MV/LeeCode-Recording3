package Main;

public class Pro28 {
    public static void main(String args[]){
        Pro28 p=new Pro28();
        String ha="hello";
        String ne="ll";
        p.strStr(ha,ne);
    }
    /*public int strStr(String haystack,String needle){
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int flag=0;
        int i=0;
        while(i<haystack.length()){
            int temp=i;
            while(temp<haystack.length()&&haystack.charAt(temp)==needle.charAt(flag)){
                temp++;
                flag++;
                if(flag==needle.length()){
                    return (i);
                }
            }
            flag=0;
            i++;
        }
        return -1;
    }*/
    public int strStr(String haystack, String needle) {
        // 各种边界情况
        if (needle.length()==0) return 0;
        if(haystack.length()==0) return -1;

        int M = haystack.length();
        int N = needle.length();
        for (int i = 0; i <= M - N; i++) {
            int j = 0;
            while (j < N && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }
            if (j == N) {
                return i;
            } else {
                // 前面都属于暴力匹配部分，下面代码在字符串needle中，从后往前寻找第一个与字符haystack.charAt(i + N)相等的字符，
                // 从而获得下一个合适的i，目的是尽量增加每一次的移动步数。
                int k = N - 1;
                while (k >= 0 && i + N < M && needle.charAt(k) != haystack.charAt(i + N)) {
                    k--;
                }
                if (k < 0) {
                    i = i + N;
                } else {
                    i = i + N - 1 - k;
                }
            }
        }
        return -1;
    }
}
