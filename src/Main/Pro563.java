package Main;

import com.sun.scenario.effect.Brightpass;

public class Pro563 {
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
   private int sum = 0;
    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int x = helper(node.left);
        int y = helper(node.right);
        sum += Math.abs(x - y);
        return (x + y + node.val);
    }
}
