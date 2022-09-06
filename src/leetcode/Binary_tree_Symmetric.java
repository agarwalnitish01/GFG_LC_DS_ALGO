package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_Symmetric {
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


    public static boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null)
            return false;

        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        que1.add(root.left);
        que2.add(root.right);

        while (!que1.isEmpty() && !que2.isEmpty()) {

            TreeNode n1 = que1.poll();
            TreeNode n2 = que2.poll();

            if (n1.val != n2.val)
                return false;

            if (n1.left != null && n2.right != null) {
                que1.add(n1.left);
                que2.add(n2.right);
            }else if (n1.left != null ^ n2.right != null) {
                return false;
            }

            if (n1.right != null && n2.left != null) {
                que1.add(n1.right);
                que2.add(n2.left);
            }else if (n1.right == null ^ n2.left == null) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        /*
                    1
               2        2
            4    5    5    4
        */

        System.out.println(isSymmetric(tree));

    }
}
