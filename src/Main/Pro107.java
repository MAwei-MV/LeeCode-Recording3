package Main;

import java.util.*;

class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }
  }

public class Pro107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        Stack<List<Integer>> stack =new Stack<>();
        List<List<Integer>> ll= new ArrayList<>();
        if(root==null) return ll;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int flag=queue.size();
            List<Integer> list =new ArrayList<>();
            while(flag>0){
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                list.add(queue.poll().val);
                flag--;
            }
            stack.add(list);
        }
        while(!stack.isEmpty()){
            ll.add(stack.pop());
        }
        return ll;
    }
}
