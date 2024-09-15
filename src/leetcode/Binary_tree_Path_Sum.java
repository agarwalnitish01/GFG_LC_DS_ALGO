package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_Path_Sum {
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

    public static boolean pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();

            if(node.val == targetSum && node.left==null && node.right==null)
                return true;

            if(node.left!=null) {
                node.left.val =  node.left.val + node.val;
                que.add(node.left);
            }

            if(node.right!=null) {
                node.right.val = node.right.val + node.val;
                que.add(node.right);
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){  // Base case
            return false;
        }

        // If it's a leaf node, check if the current sum equals the targetSum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val); // traverse left and right
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

     System.out.print(pathSum(tree,8));

    }
}
