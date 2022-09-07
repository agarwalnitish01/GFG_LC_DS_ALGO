package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class Binary_tree_Insert {
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


    public static TreeNode insert(TreeNode root,int target) {
        if(root==null){
            return new TreeNode(target);
        }
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode last = root;
        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0 ; i < l ; i++){
                TreeNode n = queue.poll();

                if(n == null)
                    break;

                if(target < n.val) {
                    if (n.left != null) {
                        last = n.left;
                        queue.add(n.left);
                    }
                } else {
                    if (n.right != null) {
                        last = n.right;
                        queue.add(n.right);
                    }
                }
            }
        }
        if(last.val > target)
            last.left = new TreeNode(target);
        else
            last.right = new TreeNode(target);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        //tree.left = new TreeNode(2);
        tree.right = new TreeNode(7);
        //tree.left.left = new TreeNode(1);
        //tree.left.right = new TreeNode(3);
        tree.right.left = null;
        tree.right.right = null;//new TreeNode(9);

        /*
                    4
               2        7
            1    3    6    9
        */
        TreeNode result = insert(tree,6);
        TreeNode result1 = insert(null,6);
        System.out.print(result);
    }

}
