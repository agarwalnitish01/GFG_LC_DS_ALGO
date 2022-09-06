package leetcode;
import java.util.*;

public class Binary_tree_Max_Depth {
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

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int d = 0;
        while(!que.isEmpty()){
            d++;
            int len = que.size();
            for(int i = 0 ; i < len ; i++){
                TreeNode n = que.poll();

                if(n == null)
                    break;

                if(n.left != null)
                    que.add(n.left);

                if(n.right != null)
                    que.add(n.right);

            }
        }
        return d;
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

     System.out.print(maxDepth(tree));

    }
}
