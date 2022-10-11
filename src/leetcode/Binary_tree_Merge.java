package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_Merge {

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

        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);

        TreeNode TreeNode = mergeTrees(tree,tree1);

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(t1);
        q.add(t2);
        // we will be updating t2 to the new tree
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                TreeNode n1 = q.poll();
                TreeNode n2 = q.poll();
                if(n1 == null || n2 == null)
                    continue;
                n1.val = n1.val + n2.val;

                if(n1.left == null)
                    n1.left = n2.left;
                else {
                    q.add(n1.left);
                    q.add(n2.left);
                }

                if(n1.right == null)
                    n1.right = n2.right;
                else {
                    q.add(n1.right);
                    q.add(n2.right);
                }
            }
        }

        return t1;
    }
}
