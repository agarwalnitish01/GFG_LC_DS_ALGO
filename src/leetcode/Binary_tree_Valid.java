package leetcode;

import java.util.*;


public class Binary_tree_Valid {
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


    public static boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root,result);

        for(int i = 1;i < result.size();i++) {
            if(result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void traverse(TreeNode node,List<Integer> result) {
        if(node  == null) { return; }
        traverse(node.left,result);
        result.add(node.val);
        traverse(node.right,result);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(6);
        tree.left.left = null;
        tree.left.right = null;
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(7);

        /*
                    4
               2        7
            1    3    6    9
        */

        System.out.print(isValidBST(tree));
    }

}
