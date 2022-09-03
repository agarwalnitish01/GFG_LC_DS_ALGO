package leetcode;

import java.util.*;


public class Binary_tree_InOrder {
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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        inorder(root,integers);
        return integers;
    }

    public static void  inorder(TreeNode root,List<Integer> result) {
        if(root==null) {
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        /*
                    1
               2        3
            4    5    6    7




        */

        for(int a : inorderTraversal(tree)){
            System.out.println(a);
        }
    }
}
