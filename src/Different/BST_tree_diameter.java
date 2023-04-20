package Different;

public class BST_tree_diameter  {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }
        dfs(root);

        return res;
    }

    public int dfs(TreeNode root){

        if(root==null){

            return 0;
        }

        int left = dfs(root.left);

        int right = dfs(root.right);

        res = Math.max(res,left+right);

        return 1+Math.max(left,right);

    }
}
