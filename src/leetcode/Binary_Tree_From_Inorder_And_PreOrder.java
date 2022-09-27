package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Binary_Tree_From_Inorder_And_PreOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int preIndex = 0;

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, map);
    }

    private static TreeNode helper(int[] preorder, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        int mid = map.get(rootValue);
        root.left = helper(preorder, left, mid - 1, map);
        root.right = helper(preorder, mid + 1, right, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        printInorder(buildTree2(preorder, inorder));
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }


}
