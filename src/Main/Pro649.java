package Main;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.LinkedList;
import java.util.Queue;

public class Pro649 {
    /*public String predictPartyVictory(String senate){
        Queue<Integer> R=new LinkedList<Integer>();
        Queue<Integer> D=new LinkedList<Integer>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
              R.offer(i);
            }
            else D.offer(i);
        }
        while(!R.isEmpty()&&!D.isEmpty()){
            int i=R.poll();
            int j=D.poll();
            if(i<j) R.offer(i+senate.length());
            else D.offer(j+senate.length());
        }
         return R.isEmpty()?"Dire":"Radiant";
    }*/

    public static void main(String args[]){
        Pro649 p=new Pro649();
        System.out.println(p.predictPartyVictory("RRDDD"));
    }

    public String predictPartyVictory(String senate){
        int totalR=0;
        int totalD=0;
        int curR=0;
        int curD=0;
        char [] c=senate.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='R') totalR++;
            else totalD++;
        }

        while(totalD!=0&&totalR!=0){
            for(int i=0;i<c.length;i++){
                if(c[i]=='R'){
                    if(curR==0) {
                        curD++;
                    }
                    else{
                        if(totalR==0) return "Dire";
                        curR--;
                        c[i]='r';
                        totalR--;
                    }
                }
                if(c[i]=='D'){
                    if(curD==0) {
                        curR++;
                    }
                    else{
                        if(totalD==0) return "Radiant";
                        curD--;
                        c[i]='d';
                        totalD--;
                    }
                }
            }
        }
        return totalD==0?"Radiant":"Dire";
    }
}
