package Main;

import java.util.ArrayList;
import java.util.List;

public class Pro1382 {
    public TreeNode balanceBST(TreeNode root) {
        //利用二叉搜索树的性质，中序遍历输出，
        //然后以中间为root，递归构造树，效率更高，算是本题的最优解。
        List<Integer> sortNode = new ArrayList<>();
        inOrder(root, sortNode);
        return reBuildTree(sortNode, 0, sortNode.size() - 1);
    }

    //中序遍历搜索树
    private void inOrder(TreeNode node, List<Integer> sortNode) {
        if (node != null) {
            inOrder(node.left, sortNode);
            sortNode.add(node.val);
            inOrder(node.right, sortNode);
        }
    }

    //重新建立二叉树
    private TreeNode reBuildTree(List<Integer> sortNode, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortNode.get(mid));
        root.left = reBuildTree(sortNode, start, mid - 1);
        root.right = reBuildTree(sortNode, mid + 1, end);
        return root;
    }
}
