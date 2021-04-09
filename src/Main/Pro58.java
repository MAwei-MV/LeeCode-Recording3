package Main;

public class Pro58 {
    public int lengthOfLastWord(String s) {
    int end=s.length()-1;
    int i=end;
    for(;i>=0;i--){
        if(i<0) return 0;
        if(s.charAt(i)!=' ') break;
    }
    int j=i;
    for(;j>=0;j--){
        if(s.charAt(j)==' ') break;
    }
    return i-j;
    }}