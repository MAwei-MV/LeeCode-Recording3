package Main;

public class Pro738 {
    //回过头看看
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int length = chars.length;
        for (int i=length-1;i>0;i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                for (int j=i;j<length;j++){
                    chars[j]='9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}