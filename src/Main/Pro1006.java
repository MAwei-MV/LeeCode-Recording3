package Main;

import java.util.Stack;

public class Pro1006 {
    public int clumsy(int N) {
        Stack<Integer> stack=new Stack<>();
        int index=1;
        stack.push(N);
        for(int i=N-1;i>0;i--){
            if(index%4==0)
                stack.push(-i);
            else if(index%4==1)
                stack.push(stack.pop()*i);
            else if(index%4==2)
                stack.push(stack.pop()/i);
            else if(index%4==3)
                stack.push(i);
            index++;
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}