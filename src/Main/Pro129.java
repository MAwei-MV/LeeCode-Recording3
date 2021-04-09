package Main;

public class Pro129 {
    int res = 0;

    public int sumNumber(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int value) {
        if (node.left == null && node.right == null) {
            res += 10 * value + node.val;
            return;
        }
        int val = 10 * value + node.val;
        if (node.left != null)
            helper(node.left, val);
        if (node.right != null)
            helper(node.right, val);
    }
}
