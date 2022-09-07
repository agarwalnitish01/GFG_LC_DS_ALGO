package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Binary_tree_Two_Sum {
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


    public static boolean twoSum(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(root);
        set.add(root.val);
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode n = queue.poll();

                if (n == null)
                    break;

                if (set.contains(target - n.val))
                    return true;
                else
                    set.add(root.val);


                if (n.left != null)
                    queue.add(n.left);


                if (n.right != null)
                    queue.add(n.right);

            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = null;
        tree.right.right = new TreeNode(7);

        /*
                    4
               2        7
            1    3    6    9
        */

        System.out.print(twoSum(tree, 9));
    }

}
