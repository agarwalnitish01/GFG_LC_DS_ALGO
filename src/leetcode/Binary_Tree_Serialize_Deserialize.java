package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Serialize_Deserialize {

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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                str.append("n ");
                continue;
            }
            str.append(node.val).append(" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode node = q.remove();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.offer(left);
            }
            i++;
            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        //tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        /*
                    3
               5        1
            6    2    0    8
                7  4
        */

        String s = serialize(tree);
        System.out.println(s);
        TreeNode tree1 = deserialize(s);
        List<List<Integer>> result = levelOrder(tree1);
        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            List<Integer> current = new ArrayList<>();
            for(int i = 0 ; i < l ; i++){
                TreeNode n = queue.poll();

                if(n!= null) {
                    current.add(n.val);
                    queue.add(n.left);
                    queue.add(n.right);
                }
            }
            result.add(current);
        }
        result.remove(result.size() - 1 );
        return result;
    }
}
