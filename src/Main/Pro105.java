package Main;

import java.util.HashMap;

public class Pro105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int N = preorder.length;
        if (N == 0 || preorder == null) return null;
        //val到下标的映射
        for (int i = 0; i < N; i++) {
            hm.put(inorder[i], i);
        }
        return helper(preorder, 0, N - 1, inorder, 0, N - 1, hm);
    }

    private TreeNode helper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2, HashMap<Integer, Integer> hm) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        int index = hm.get(preorder[start1]);
        TreeNode root = new TreeNode(preorder[start1]);
        root.left = helper(preorder, start1 + 1, start1 + index - start2, inorder, start2, index - 1, hm);
        root.right = helper(preorder, start1 + index - start2 + 1, end1, inorder, index + 1, end2, hm);
        return root;
    }
}
