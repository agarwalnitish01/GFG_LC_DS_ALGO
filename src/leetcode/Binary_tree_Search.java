package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Binary_tree_Search {
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


    public static TreeNode search(TreeNode root,int target) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0 ; i < l ; i++){
                TreeNode n = queue.poll();

                if(n == null)
                    break;

                if(n.val==target)
                    return n;

                if(target < n.val) {
                    if (n.left != null)
                        queue.add(n.left);
                } else {

                    if (n.right != null)
                        queue.add(n.right);
                }
            }
        }
        return null;
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
        TreeNode result = search(tree,7);
        System.out.print(result);
    }

}
