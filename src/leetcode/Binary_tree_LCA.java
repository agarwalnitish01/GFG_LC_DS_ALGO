package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class Binary_tree_LCA {
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


    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        while(root != null){
            int curr = root.val;

            if(curr < p.val && curr < q.val)
                root = root.right;
            else if(curr > p.val && curr>q.val)
                root = root.left;
            else
                break;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(7);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(9);

        /*
                    4
               2        7
            1    3    6    9
        */
        TreeNode result = lowestCommonAncestor(tree,tree.left.left,tree.left.right);
        System.out.print(result.val);
    }

}
