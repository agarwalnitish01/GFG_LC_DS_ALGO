package leetcode;

import java.util.*;


public class Binary_tree_Point_Left_Tree_To_Right {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node connect(Node root) {
        Node head=root;
        while(head!=null){
            Node dummy=new Node(0);
            Node temp=dummy;
            while(head!=null){
                if(head.left!=null){
                    temp.next=head.left;
                    temp=temp.next;
                }
                if(head.right!=null){
                    temp.next=head.right;
                    temp=temp.next;
                }
                head=head.next;
            }
            head=dummy.next;
        }
        return root;
    }

    public static void main(String[] args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        /*
                    1
               2        3
            4    5    6    7

        */

        Node treeNode =  connect1(tree);
    }

    public static Node connect1(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            // For each level create a list array to store same level node details
            List<Node> level=new ArrayList<>();
            int size=queue.size();

            for(int i=0;i<size;i++){
                Node top=queue.poll();
                level.add(top);

                if(top.left!=null)
                    queue.add(top.left);
                if(top.right!=null)
                    queue.add(top.right);
            }

            //For each level get the node and point out to next node irrespective of considering parent of current node element
            for(int i=0;i<size-1;i++){
                level.get(i).next=level.get(i+1);
            }
            //Last element of each level points to null
            level.get(size-1).next=null;
        }

        return root;

    }

}
