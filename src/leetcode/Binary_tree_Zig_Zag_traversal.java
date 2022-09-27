package leetcode;

import java.util.*;

public class Binary_tree_Zig_Zag_traversal {
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


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = true;
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
            if(reverse) {
                Collections.reverse(current);
                result.add(current);
                reverse = false;
            }else{
                result.add(current);
                reverse = true;
            }
        }
        result.remove(result.size() - 1);
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

        List<List<Integer>> result = levelOrder(tree);
        for (List<Integer> list : result) {
            for (int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
