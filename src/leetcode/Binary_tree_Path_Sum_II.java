package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_tree_Path_Sum_II {

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

        public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            helper(new ArrayList<>(), root, 0, targetSum, result);
            return result;
        }

        public static void helper(List<Integer> path, TreeNode node, int sum, int target, List<List<Integer>> result) {
            if (node == null) {
                return;
            }

            path.add(node.val);
            sum = sum +node.val;

            if (node.left == null && node.right == null && sum == target) {
                result.add(new ArrayList<>(path));
            }

            helper(path, node.left, sum, target, result);
            helper(path, node.right, sum, target, result);

            // Backtrack: Remove the last element to explore other paths
            path.remove(path.size() - 1);
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
