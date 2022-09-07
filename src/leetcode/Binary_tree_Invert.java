package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Binary_tree_Invert {
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


    public static void invert(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0 ; i < l ; i++){
                TreeNode n = queue.poll();
                if(n!= null) {
                    queue.add(n.left);
                    queue.add(n.right);

                    TreeNode treeNode = n.left;
                    n.left = n.right;
                    n.right= treeNode;

                }
            }
        }
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
        printTree(levelOrder(tree));
        System.out.println();
        invert(tree);
        printTree(levelOrder(tree));
    }

    private static void printTree(List<List<Integer>> levelOrder) {
        for (List<Integer> list : levelOrder) {
            for (int a : list) {
                System.out.print(a + " ");
            }
        }
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
