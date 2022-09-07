package leetcode;

import java.util.*;


public class Binary_tree_InOrder {
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

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        preOrder(root,integers);
        return integers;
    }

    public static void  preOrder(TreeNode root,List<Integer> result) {
        if(root==null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        inorder(root,integers);
        return integers;
    }

    public static void  inorder(TreeNode root,List<Integer> result) {
        if(root==null) {
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        postOrder(root,integers);
        return integers;
    }

    public static void  postOrder(TreeNode root,List<Integer> result) {
        if(root==null) {
            return;
        }
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
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

        for(int a : preOrderTraversal(tree)){
            System.out.print(a+ " ");
        }
        System.out.println();
        preOrderIterative(tree);
        System.out.println();
        for(int a : inorderTraversal(tree)){
            System.out.print(a+ " ");
        }
        System.out.println();
        inorderIterative(tree);
        System.out.println();
        for(int a : postOrderTraversal(tree)){
            System.out.print(a+ " ");
        }
    }

    public static void inorderIterative(TreeNode root)
    {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr !=  null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }


    public static void preOrderIterative(TreeNode root)
    {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                if (curr.right != null)
                    stack.push(curr.right);

                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }
}
