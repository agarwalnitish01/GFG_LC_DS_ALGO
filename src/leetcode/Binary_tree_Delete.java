package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Binary_tree_Delete {
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


    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = findMinimum(root.left);
            root.left = deleteNode(root.left, root.val);

        }
        return root;
    }

    public static int findMinimum(TreeNode root) {
        int min = root.val;
        while (root.right != null) {
            min = root.right.val;
            root = root.right;
        }
        return min;
    }

    public static void main(String[] args) {
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

        System.out.print(levelOrder(deleteNode(tree, 3)));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int l = queue.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode n = queue.poll();

                if (n != null) {
                    current.add(n.val);
                    queue.add(n.left);
                    queue.add(n.right);
                }
            }
            result.add(current);
        }
        result.remove(result.size() - 1);
        return result;
    }
}
