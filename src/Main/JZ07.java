package Main;

public class JZ07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        int[] newPro = new int[i];
        int[] newinorder = new int[i];
        int[] newLast = new int[preorder.length - i - 1];
        int[] newlastInorder = new int[preorder.length - i - 1];
        for (int j = 0; j <= i - 1; j++) {
            newPro[j] = preorder[j + 1];
            newinorder[j] = inorder[j];
        }
        for (int k = 0; k < preorder.length - i - 1; k++) {
            newLast[k] = preorder[i + 1 + k];
            newlastInorder[k] = inorder[i + 1 + k];
        }
        root.left = buildTree(newPro, newinorder);
        root.right = buildTree(newLast, newlastInorder);
        return root;
    }

}
