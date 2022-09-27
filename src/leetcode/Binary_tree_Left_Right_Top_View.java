package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_Left_Right_Top_View {
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


    public static List<Integer> leftview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==0) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
    }


    public static List<Integer> rightview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==size-1) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
    }

    public static List<Integer> topview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==0) {
                        result.add(n.val);
                    }
                    if(i!=0 && i==size-1) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
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

        for (Integer list : leftview(tree)) {
            System.out.print(list + " ");
        }
        System.out.println();
        for (Integer list : rightview(tree)) {
            System.out.print(list + " ");
        }
        System.out.println();
        for (Integer list : topview(tree)) {
            System.out.print(list + " ");
        }
    }
}
