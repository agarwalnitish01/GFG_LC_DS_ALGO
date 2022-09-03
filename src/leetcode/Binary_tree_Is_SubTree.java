package leetcode;

import java.util.*;


public class Binary_tree_Is_SubTree {
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

    public static boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }


        if(root.val==subRoot.val){
            return (isIdentical(root.left ,subRoot.left) && isIdentical(root.right ,subRoot.right));
        }else{
            return false;
        }

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot==null){
            return true;
        }

        if(root==null){
            return false;
        }
        if(isIdentical(root,subRoot)){
            return true;
        }

        if(isSubtree(root.left,subRoot)){
            return true;
        } else if(isSubtree(root.right,subRoot)){
            return true;
        }else{
            return false;
        }
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

        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);

        System.out.println(isSubtree(tree,tree1));
        System.out.println(isSubtreeBFS(tree,tree1));
    }







    private static boolean isSameTree(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(t1);
        queue.add(t2);

        while (!queue.isEmpty()) {

            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }

            queue.add(n1.left);
            queue.add(n2.left);

            queue.add(n1.right);
            queue.add(n2.right);

        }

        return true;
    }


    public static boolean isSubtreeBFS(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        else if (root != null && subRoot == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            if (isSameTree(node, subRoot)) {
                return true;
            }

            queue.add(node.left);
            queue.add(node.right);

        }

        return false;

    }
}
