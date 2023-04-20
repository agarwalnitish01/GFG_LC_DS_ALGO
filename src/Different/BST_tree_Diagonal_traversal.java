package Different;

import java.util.*;

    public class BST_tree_Diagonal_traversal {
        // Tree node
        static class Node {
            int data;
            Node left;
            Node right;
            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        static class TNode {
            Node node;
            int level;
            public TNode(Node n, int l){
                this.node = n;
                this.level = l;
            }
        }

        public static void diagonalPrint(Node root){
            if (root == null) return;

            TreeMap<Integer, List<Integer> > map = new TreeMap<Integer, List<Integer> >();

            Queue<TNode> q = new LinkedList<TNode>();
            q.add(new TNode(root, 0));

            while (!q.isEmpty()) {
                TNode curr = q.poll();
                map.putIfAbsent(curr.level, new ArrayList<>());
                map.get(curr.level).add(curr.node.data);

                if (curr.node.left != null)
                    q.add(new TNode(curr.node.left, curr.level + 1));

                if (curr.node.right != null)
                    q.add(new TNode(curr.node.right, curr.level));
            }

            for (Map.Entry<Integer, List<Integer> > entry : map.entrySet()) {
                int k = entry.getKey();

                List<Integer> l = map.get(k);
                int size = l.size();

                for (int i = 0; i < l.size(); i++) {
                    System.out.print(l.get(i));
                    System.out.print(" ");
                }
                System.out.println("");
            }
            return;
        }

        // Driver code
        public static void main(String[] args){
            Node root = new Node(8);
            root.left = new Node(3);
            root.right = new Node(10);
            root.left.left = new Node(1);
            root.left.right = new Node(6);
            root.right.right = new Node(14);
            root.right.right.left = new Node(13);
            root.left.right.left = new Node(4);
            root.left.right.right = new Node(7);

            diagonalPrint(root);
        }
    }
