package leetcode;

import java.util.*;

public class Binary_tree_Left_Right_Top_View {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int hd;

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


    public static List<Integer> leftview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==0) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
    }


    public static List<Integer> rightview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==size-1) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
    }

    public static List<Integer> topview(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n != null) {
                    if(i==0) {
                        result.add(n.val);
                    }
                    if(i!=0 && i==size-1) {
                        result.add(n.val);
                    }
                    if(n.left!=null) {
                        queue.add(n.left);
                    }
                    if(n.right!=null) {
                        queue.add(n.right);
                    }
                }
            }
        }

        return result;
    }

    static class pair {
        TreeNode first;
        int second;
        pair(TreeNode f, int s)
        {
            first = f;
            second = s;
        }
    }
    public static Collection<Integer> bottomView(TreeNode root)
    {
        if (root == null)
            return new ArrayList<>(); // if root is NULL
        HashMap<Integer, Integer> hash = new HashMap<>(); // <vertical_index ,// root->data>
        int leftmost = 0; // to store the leftmost index so// that we move from left to right
        Queue<pair> q = new ArrayDeque<>();

        q.add(new pair(
                root, 0));
        while (!q.isEmpty()) {
            pair top = q.peek();
            q.remove();
            TreeNode temp = top.first; // store the Node in temp for
            // left and right nodes
            int ind = top.second; // store the vertical
            // index of current node
            hash.put(ind, temp.val); // store the latest
            // vertical_index(key) ->
            // root->data(value)
            leftmost = Math.min(
                    ind, leftmost); // have the leftmost
            // vertical index
            if (temp.left != null) {
                q.add(new pair(temp.left, ind - 1));
            } // check if any node of left then go in
            // negative direction
            if (temp.right != null) {
                q.add(new pair(temp.right, ind + 1));
            } // check if any node of left then go in
            // positive direction
        }
        // Traverse each value in hash from leftmost to
        // positive side till key is available
        List<Integer> result = new ArrayList<>();
        while (hash.containsKey(leftmost)) {
            result.add(hash.getOrDefault(leftmost++, 0));
        }
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

        for (Integer list : leftview(tree)) {
            System.out.print(list + " ");
        }
        System.out.println();
        for (Integer list : rightview(tree)) {
            System.out.print(list + " ");
        }
        System.out.println();
        for (Integer list : topview(tree)) {
            System.out.print(list + " ");
        }
        System.out.println();
        for(Integer list: bottomView(tree) ){
            System.out.print(list + " ");
        }

    }
}
